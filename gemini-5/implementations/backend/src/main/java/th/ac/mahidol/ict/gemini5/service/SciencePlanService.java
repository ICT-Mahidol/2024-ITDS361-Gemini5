package th.ac.mahidol.ict.gemini5.service;

import th.ac.mahidol.ict.gemini5.model.DataProcRequirement;
import th.ac.mahidol.ict.gemini5.model.SciencePlan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SciencePlanService {

    private final OCSServiceClient ocsServiceClient;

     @Autowired
    public SciencePlanService(OCSServiceClient ocsServiceClient) {
        this.ocsServiceClient = ocsServiceClient;
    }

    /** Get all Science Plans */
    public List<SciencePlan> getAllSciencePlans() {
        return ocsServiceClient.getAllSciencePlans();
    }

    /** Get a Science Plan by ID */
    public SciencePlan getSciencePlanById(int id) {
        return ocsServiceClient.getSciencePlanById(id);
    }

    /** Get all Science Plans by Status */
    public List<SciencePlan> getSciencePlanByStatus(SciencePlan.Status status) {
        List<SciencePlan> allPlans = getAllSciencePlans();
        return allPlans.stream()
                .filter(plan -> plan.getStatus() == status)
                .collect(Collectors.toList());
    }

    /** Update the status of a Science Plan */
    public boolean updateSciencePlanStatus(int planId, SciencePlan.Status newStatus) {
        return ocsServiceClient.updateSciencePlanStatus(planId, newStatus);
    }

    /** Execute Science Plan */
    public String runSciencePlan(int planId) {
        SciencePlan sp = getSciencePlanById(planId);

        if (sp == null) {
            return "Science Plan not found";
        }

        if (sp.getStatus() != SciencePlan.Status.VALIDATED) {
            return "Science Plan must be VALIDATED before execution. Please validate first.";
        }

        boolean executionSuccess = ocsServiceClient.runSciencePlan(sp);
        if (executionSuccess) {
            boolean statusUpdated = updateSciencePlanStatus(planId, SciencePlan.Status.RUNNING);
            return statusUpdated ? "Science Plan has been executed successfully."
                                  : "Executed but cannot update status.";
        } else {
            return "Executed failed.";
        }
    }

    /** Validate a Science Plan */
    public String validateSciencePlan(int planId) {
        SciencePlan sp = getSciencePlanById(planId);
        
        if (sp == null) {
            return "Science Plan not found.";
        }
    
        if (sp.getStatus() != SciencePlan.Status.SUBMITTED) {
            return "Science Plan is not in SUBMITTED status, cannot validate.";
        }

        if (!isSciencePlanValid(sp)) {
            // Validation failed → Invalidate plan
            boolean invalidated = updateSciencePlanStatus(planId, SciencePlan.Status.INVALIDATED);
            return invalidated ? "Validation failed. Plan INVALIDATED."
                            : "Validation failed and failed to update status.";
        }

        // Validation pass → Validate plan
        boolean validated = updateSciencePlanStatus(planId, SciencePlan.Status.VALIDATED);
        return validated ? "Validate Science Plan Succeed ID: " + planId
                        : "Validation attempted but status not updated.";
    }
    

    private boolean isSciencePlanValid(SciencePlan plan) {
        if (plan.getCreator() == null || 
            plan.getFunding() <= 0 || 
            plan.getObjectives() == null || 
            plan.getStartDate() == null || 
            plan.getEndDate() == null || 
            plan.getTelescope() == null || 
            plan.getTarget() == null) {
            return false;
        }

        List<DataProcRequirement> requirements = plan.getDataProcRequirements();
        if (requirements == null || requirements.isEmpty()) {
            return false;
        }
        
        return requirements.stream().allMatch(DataProcRequirement::isValid);
    }


}
