package th.ac.mahidol.ict.gemini5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import th.ac.mahidol.ict.gemini5.service.ErrorLogService;
import th.ac.mahidol.ict.gemini5.model.ObservingProgram;
import th.ac.mahidol.ict.gemini5.service.ObservingProgramService;

@RestController
@RequestMapping("/api/observing-program")
public class ObservingProgramController {

    private final ObservingProgramService observingProgramService;

    @Autowired
    private ErrorLogService errorLogService;
    public ObservingProgramController(ObservingProgramService observingProgramService) {
        this.observingProgramService = observingProgramService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createObservingProgram(@RequestBody ObservingProgram program) {
        try {
            String result = observingProgramService.createObservingProgram(program);
            if (result.contains("successfully")) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.badRequest().body(result);
            }
        } catch (Exception e) {
            // 👉 บันทึก error ลง DB
            errorLogService.logError(e, Long.valueOf(program.getPlanID()));
            return ResponseEntity.status(500).body("เกิดข้อผิดพลาดระหว่างสร้าง Observing Program: " + e.getMessage());
        }
    }

    @GetMapping("/{planId}")
    public ResponseEntity<?> getObservingProgram(@PathVariable int planId) {
        ObservingProgram program = observingProgramService.getObservingProgramByPlanId(planId);
        if (program != null) {
            return ResponseEntity.ok(program);
        } else {
            return ResponseEntity.badRequest().body("Observing Program not found for plan ID: " + planId);
        }
    }
}
