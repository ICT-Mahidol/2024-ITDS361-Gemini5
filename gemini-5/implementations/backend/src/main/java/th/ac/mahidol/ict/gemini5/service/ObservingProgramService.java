package th.ac.mahidol.ict.gemini5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.mahidol.ict.gemini5.model.ObservingProgram;
import th.ac.mahidol.ict.gemini5.model.SciencePlan;
import th.ac.mahidol.ict.gemini5.repository.ObservingProgramRepository;

import java.util.Optional;

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
            SciencePlan plan = sciencePlanService.getSciencePlanById(program.getPlanID());

            if (plan == null) throw new IllegalArgumentException("Science Plan not found.");
            if (plan.getStatus() != SciencePlan.Status.VALIDATED)
                throw new IllegalStateException("No validated science plans found");

            // ตรวจสอบ field บังคับ
            if (program.getGeminiLocation() == null || program.getGeminiLocation().isEmpty() ||
                    program.getOpticsPrimary() == null || program.getOpticsPrimary().isEmpty() ||
                    program.getScienceFoldMirrorType() == null || program.getScienceFoldMirrorType().isEmpty() ||
                    program.getModuleContent() == null || program.getModuleContent().isEmpty() ||
                    program.getCalibrationUnit() == null || program.getCalibrationUnit().isEmpty() ||
                    program.getLightType() == null || program.getLightType().isEmpty() ||
                    program.getTelescopePositionPair() == null || program.getTelescopePositionPair().length < 2 ||
                    !isValidDouble(program.getFStop()) ||
                    !isValidDouble(program.getOpticsSecondaryRMS()) ||
                    !isValidDouble(program.getScienceFoldMirrorDegree())) {
                throw new IllegalArgumentException("Missing required fields or invalid data format in Observing Program.");
            }

            // ตรวจสอบประเภทข้อมูลสำหรับตัวแปรที่เป็น double
            if (!isValidDouble(program.getTelescopePositionPair()[0]) ||
                    !isValidDouble(program.getTelescopePositionPair()[1])) {
                throw new IllegalArgumentException("Telescope Position Pair values should be valid doubles.");
            }

            // บันทึกโปรแกรม
            programRepo.save(program);
            sciencePlanService.updateSciencePlanStatus(program.getPlanID(), SciencePlan.Status.RUNNING);

            return "Observing Program created successfully.";

        } catch (Exception e) {
            errorLogService.logError(e, Long.valueOf(program.getPlanID()));  // แปลงเป็น Long
            return "An error occurred while creating the Observing Program: " + e.getMessage();
        }
    }

    private boolean isValidDouble(double value) {
        return !Double.isNaN(value) && !Double.isInfinite(value);
    }



    public ObservingProgram getObservingProgramByPlanId(int planId) {
        Optional<ObservingProgram> result = programRepo.findById(planId);
        return result.orElse(null);
    }
}
