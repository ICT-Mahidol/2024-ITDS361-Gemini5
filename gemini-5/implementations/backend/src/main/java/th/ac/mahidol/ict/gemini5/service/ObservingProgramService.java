package th.ac.mahidol.ict.gemini5.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.mahidol.ict.gemini5.model.ObservingProgram;
import th.ac.mahidol.ict.gemini5.model.SciencePlan;
import th.ac.mahidol.ict.gemini5.repository.ObservingProgramRepository;

@Service
public class ObservingProgramService {

    private final ObservingProgramRepository programRepo;
    private final SciencePlanService sciencePlanService;
    private final ErrorLogService errorLogService;

    @Autowired
    public ObservingProgramService(
            ObservingProgramRepository programRepo,
            SciencePlanService sciencePlanService,
            ErrorLogService errorLogService) {
        this.programRepo = programRepo;
        this.sciencePlanService = sciencePlanService;
        this.errorLogService = errorLogService;
    }

    public String createObservingProgram(ObservingProgram program) {
        try {
            // 1. ตรวจสอบว่าไม่พบ Science Plan
            SciencePlan plan = sciencePlanService.getSciencePlanById(program.getPlanID());
            if (plan == null) {
                String message = "Science Plan not found.";
                errorLogService.logError(new IllegalArgumentException(message), Long.valueOf(program.getPlanID()));
                return message;
            }

            // // 2. ตรวจสอบว่า Science Plan ไม่ใช่สถานะ VALIDATED
            // if (plan.getStatus() != SciencePlan.Status.VALIDATED) {
            //     String message = "No validated science plans found.";
            //     errorLogService.logError(new IllegalStateException(message), Long.valueOf(program.getPlanID()));
            //     return message;
            // }

            // // 3. ตรวจสอบข้อมูลที่บังคับ
            // if (program.getGeminiLocation() == null || program.getGeminiLocation().isEmpty() ||
            //         program.getOpticsPrimary() == null || program.getOpticsPrimary().isEmpty() ||
            //         program.getScienceFoldMirrorType() == null || program.getScienceFoldMirrorType().isEmpty() ||
            //         program.getModuleContent() == null || program.getModuleContent().isEmpty() ||
            //         program.getCalibrationUnit() == null || program.getCalibrationUnit().isEmpty() ||
            //         program.getLightType() == null || program.getLightType().isEmpty() ||
            //         !isValidDouble(program.getTelescopeDirection()) ||
            //         !isValidDouble(program.getTelescopeDegree()) ||
            //         !isValidDouble(program.getFStop()) ||
            //         !isValidDouble(program.getOpticsSecondaryRMS()) ||
            //         !isValidDouble(program.getScienceFoldMirrorDegree())) {
            //     String message = "Missing required fields or invalid data format in Observing Program.";
            //     errorLogService.logError(new IllegalArgumentException(message), Long.valueOf(program.getPlanID()));
            //     return message;
            // }

            // 4. ตรวจสอบการตรวจสอบ validation logic ของ Observing Program
            program = validateObservingCondition(program);
            if (!program.isValidStatus()) {
                String message = "Observing Program validation failed due to invalid conditions.";
                return message;
            }

            // 5. ถ้ามีข้อผิดพลาดอื่นๆ ที่ไม่สามารถจัดการได้
            // บันทึกโปรแกรม
            programRepo.save(program);
            return "Observing Program created successfully.";

        } catch (Exception e) {
            // 5. Exception อื่นที่ไม่คาดคิด
            errorLogService.logError(e, Long.valueOf(program.getPlanID()));
            return "An error occurred while creating the Observing Program: " + e.getMessage();
        }
    }

    private boolean isValidDouble(double value) {
        return !Double.isNaN(value) && !Double.isInfinite(value);
    }

    // ตรวจสอบการตรวจสอบ validation ของ Observing Program
    private ObservingProgram validateObservingCondition(ObservingProgram op) {
        String opticPriGN = "GNZ";
        String opticPriGS = "GSZ";
        double fStopGNMin = 1.8;
        double fStopGNMax = 8.1;
        double fStopGSMin = 2.9;
        double fStopGSMax = 18.0;
        double opticSecNMin = 5.0;
        double opticSecNMax = 17.0;
        double opticSecSMin = 5.0;
        double opticSecSMax = 13.0;
        double sciFoldDegreeMin = 30.0;
        double sciFoldDegreeMax = 45.0;
        double movDirMin = 0.0;
        double movDirMax = 360.0;
        double movDegMin = 0.0;
        double movDegMax = 70.0;

        boolean validStatus = false;
        String geminiLoc = op.getGeminiLocation();
        String errMsg = ""; // ใช้ตัวแปรชั่วคราวแทนการเพิ่มฟิลด์ใน ObservingProgram
        String opticPriValue = op.getOpticsPrimary();
        double opticSecRMS = op.getOpticsSecondaryRMS();
        double fStopValue = op.getFStop();
        double scienceFoldValue = op.getScienceFoldMirrorDegree();

        // ตรวจสอบค่าของ fStop และแจ้งข้อผิดพลาดหากผิด
        if (opticPriValue == null || (!opticPriValue.equals(opticPriGN) && !opticPriValue.equals(opticPriGS))) {
            errMsg = "Invalid OpticsPrimary value.";
        } else if (opticPriValue.equals(opticPriGN)) {
            if (fStopValue < fStopGNMin || fStopValue > fStopGNMax) {
                validStatus = false;
                errMsg = String.format("fStop value out of range for GNZ. Expected between %.1f and %.1f, but got %.1f.", fStopGNMin, fStopGNMax, fStopValue);
            } else {
                validStatus = true;
                errMsg = "fStop value is valid.";
            }
        } else if (opticPriValue.equals(opticPriGS)) {
            if (fStopValue < fStopGSMin || fStopValue > fStopGSMax) {
                validStatus = false;
                errMsg = String.format("fStop value out of range for GSZ. Expected between %.1f and %.1f, but got %.1f.", fStopGSMin, fStopGSMax, fStopValue);
            } else {
                validStatus = true;
                errMsg = "fStop value is valid.";
            }
        }

        // ถ้าค่า fStop ถูกต้องแล้ว ให้ตรวจสอบเงื่อนไขต่อไป
        if (validStatus) {
            if ("N".equals(geminiLoc)) {
                if (opticSecRMS >= opticSecNMin && opticSecRMS <= opticSecNMax) {
                    validStatus = true;
                    errMsg = "OpticsSecondary RMS value is valid.";
                } else {
                    validStatus = false;
                    errMsg = "OpticsSecondary RMS out of range for 'N' location.";
                }
            } else {
                if (opticSecRMS >= opticSecSMin && opticSecRMS <= opticSecSMax) {
                    validStatus = true;
                    errMsg = "OpticsSecondary RMS value is valid.";
                } else {
                    validStatus = false;
                    errMsg = "OpticsSecondary RMS out of range for other locations.";
                }
            }
        }

        // ตรวจสอบความถูกต้องของ Science Fold Mirror Degree
        if (validStatus) {
            if (scienceFoldValue < sciFoldDegreeMin || scienceFoldValue > sciFoldDegreeMax) {
                validStatus = false;
                errMsg = String.format("Science Fold Mirror Degree out of range. Expected between %.1f and %.1f.", sciFoldDegreeMin, sciFoldDegreeMax);
            }
        }

        // ตรวจสอบ Telescope Position Pair
        if (validStatus) {
            double direction = op.getTelescopeDirection();
            double degree = op.getTelescopeDegree();

            if (!isValidDouble(direction) || !isValidDouble(degree)) {
                validStatus = false;
                errMsg = "Telescope direction or degree is not a valid number.";
            } else if (direction < movDirMin || direction > movDirMax) {
                validStatus = false;
                errMsg = "Direction out of range.";
            } else if (degree < movDegMin || degree > movDegMax) {
                validStatus = false;
                errMsg = "Degree out of range.";
            } else {
                validStatus = true;
                errMsg = "Telescope direction and degree are valid.";
            }
        }

        // Log the error message to the error log
        if (!validStatus) {
            errorLogService.logError(new IllegalArgumentException(errMsg), Long.valueOf(op.getPlanID()));
        }

        op.setValidationStatus(validStatus);

        // ส่งข้อความผิดพลาดกลับเป็นผลลัพธ์จากการตรวจสอบ
        return op;
    }

    public ObservingProgram getObservingProgramByPlanId(int planId) {
        Optional<ObservingProgram> result = programRepo.findById(planId);
        return result.orElse(null);
    }
}
