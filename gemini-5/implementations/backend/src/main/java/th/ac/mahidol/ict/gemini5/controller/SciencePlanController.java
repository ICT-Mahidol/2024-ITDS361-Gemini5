package th.ac.mahidol.ict.gemini5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import th.ac.mahidol.ict.gemini5.model.SciencePlan;
import th.ac.mahidol.ict.gemini5.service.SciencePlanService;

import java.util.List;

@RequestMapping("/sp")
@RestController
@CrossOrigin
public class SciencePlanController {

    private final SciencePlanService service;
    
    @Autowired
    public SciencePlanController(SciencePlanService service) {
        this.service = service;
    }
    
     /** Get all Science Plans */
    @GetMapping("/all")
    public List<SciencePlan> getAllPlans() {
        return service.getAllSciencePlans();
    }

     /** Get a Science Plan by ID */
    @GetMapping("/{id}")
    public SciencePlan getPlanById(@PathVariable int id) {
        return service.getSciencePlanById(id);
    }

    /** Get Science Plans by Status */
    @GetMapping("/status")
    public List<SciencePlan> getPlansByStatus(@RequestParam String status) {
        try {
            SciencePlan.Status statusEnum = SciencePlan.Status.valueOf(status.toUpperCase());
            return service.getSciencePlanByStatus(statusEnum);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid status value: " + status);
        }
    }

    /** Execute a Science Plan */
    @PostMapping("/run/{id}")
    public ResponseEntity<String> executePlan(@PathVariable int id) {
        String message = service.runSciencePlan(id);

        if (message.contains("successfully")) {
            return ResponseEntity.ok(message);
        } else if (message.contains("validate")) {
            // แยกกรณีพิเศษ: ต้องไป validate
            return ResponseEntity.status(409).body(message); // 409 Conflict
        } else {
            return ResponseEntity.badRequest().body(message);
        }
    }

    /** Validate a Science Plan */
    @PutMapping("/validate/{id}")
    public ResponseEntity<String> validatePlan(@PathVariable int id) {
        String message = service.validateSciencePlan(id);

        if (message.startsWith("Validate Science Plan Succeed")) {
            return ResponseEntity.ok(message); // 200 OK
        } else {
            return ResponseEntity.badRequest().body(message); // 400 Bad Request
        }
    }

    /** Inalidate a Science Plan */
    @PutMapping("/invalidate/{id}")
    public ResponseEntity<String> invalidatePlan(@PathVariable int id) {
        String message = service.invalidateSciencePlan(id);

        if (message.startsWith("Invalidate Science Plan Succeed")) {
            return ResponseEntity.ok(message); // 200 OK
        } else {
            return ResponseEntity.badRequest().body(message); // 400 Bad Request
        }
    }

    /** Update status of a Science Plan manually */
    @PutMapping("/{id}/status")
    public ResponseEntity<String> updatePlanStatus(@PathVariable int id, @RequestParam String status) {
        try {
            SciencePlan.Status newStatus = SciencePlan.Status.valueOf(status.toUpperCase());
            boolean success = service.updateSciencePlanStatus(id, newStatus);
            return success ? ResponseEntity.ok("Status updated to " + newStatus)
                        : ResponseEntity.badRequest().body("Invalid status or failed to update.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid status value: " + status);
        }
    }


}
