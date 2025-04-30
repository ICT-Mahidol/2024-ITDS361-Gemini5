package th.ac.mahidol.ict.gemini5.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.mahidol.ict.gemini5.model.SciencePlan;
import th.ac.mahidol.ict.gemini5.repository.SciencePlanRepository;
import th.ac.mahidol.ict.gemini5.facade.GeminiFacade;


@Service
public class SciencePlanService {

    private final GeminiFacade geminiFacade;
    private SciencePlanRepository sciencePlanRepository;

    @Autowired
    public SciencePlanService(GeminiFacade geminiFacade, SciencePlanRepository sciencePlanRepository) {
        this.geminiFacade = geminiFacade;
        this.sciencePlanRepository = sciencePlanRepository;
    }


    public SciencePlan saveSciencePlanToDb(SciencePlan sp) {
        SciencePlan entity = new SciencePlan();
        entity.setPlanID(sp.getPlanID());
        entity.setCreator(sp.getCreator());
        entity.setSubmitter(sp.getSubmitter());
        entity.setFunding(sp.getFunding());
        entity.setObjectives(sp.getObjectives());
        entity.setStartDate(sp.getStartDate());
        entity.setEndDate(sp.getEndDate());
        entity.setTelescope(sp.getTelescope());
        entity.setTarget(sp.getTarget());
        entity.setStatus(sp.getStatus());
    
        return sciencePlanRepository.save(entity);
    }

    /** Fetch Science Plans from OCS and save Local Database */
    public List<SciencePlan> fetchAndSaveAllFromOCS() {
        List<SciencePlan> plans = geminiFacade.getAllSciencePlans(); // ดึงมาจาก OCS

        List<SciencePlan> newPlans = plans.stream()
                .filter(plan -> !sciencePlanRepository.existsById(plan.getPlanID()))
                .collect(Collectors.toList());

        return sciencePlanRepository.saveAll(newPlans);  // แล้ว save ลง database
    }


    /** Get all Science Plans */
    public List<SciencePlan> getAllSciencePlans() {
        return sciencePlanRepository.findAll();
    }
    
    /** Get a Science Plan by ID */
    public SciencePlan getSciencePlanById(int id) {
        return sciencePlanRepository.findById(id).orElse(null);
    }

    /** Get all Science Plans by Status */
    public List<SciencePlan> getSciencePlanByStatus(SciencePlan.Status status) {
        return sciencePlanRepository.findAll().stream()
                .filter(plan -> plan.getStatus() == status)
                .collect(Collectors.toList());
    }

    /** Update the status of a Science Plan */
    public boolean updateSciencePlanStatus(int planId, SciencePlan.Status newStatus) {
        Optional<SciencePlan> optionalPlan = sciencePlanRepository.findById(planId);
        if (optionalPlan.isPresent()) {
            SciencePlan plan = optionalPlan.get();
            plan.setStatus(newStatus);
            sciencePlanRepository.save(plan);
            return true;
        }
        return false;
    }

    /** Execute Science Plan */
    public String runSciencePlan(int planId) {
        Optional<SciencePlan> optionalPlan = sciencePlanRepository.findById(planId);

        if (!optionalPlan.isPresent()) {
            return "Science Plan not found";
        }

        SciencePlan sp = optionalPlan.get();
        if (sp.getStatus() != SciencePlan.Status.VALIDATED) {
            return "Science Plan must be VALIDATED before execution. Please validate first.";
        }

        sp.setStatus(SciencePlan.Status.RUNNING);
        sciencePlanRepository.save(sp);
        return "Science Plan has been executed successfully.";
    }

    /** Validate a Science Plan */
    public String validateSciencePlan(int planId) {
        Optional<SciencePlan> optionalPlan = sciencePlanRepository.findById(planId);
        if (!optionalPlan.isPresent()) {
            return "Science Plan not found.";
        }
    
        SciencePlan sp = optionalPlan.get();
    
        if (sp.getStatus() != SciencePlan.Status.SUBMITTED) {
            return "Science Plan is not in SUBMITTED status, cannot validate.";
        }
    
        sp.setStatus(SciencePlan.Status.VALIDATED);
        sciencePlanRepository.save(sp);
        return "Validate Science Plan Succeed ID: " + planId;
    }
    
    /** Invalidate a Science Plan */
    public String invalidateSciencePlan(int planId) {
        Optional<SciencePlan> optionalPlan = sciencePlanRepository.findById(planId);
        if (!optionalPlan.isPresent()) {
            return "Science Plan not found.";
        }
    
        SciencePlan sp = optionalPlan.get();
    
        if (sp.getStatus() != SciencePlan.Status.SUBMITTED) {
            return "Science Plan is not in SUBMITTED status, cannot invalidate.";
        }
    
        sp.setStatus(SciencePlan.Status.INVALIDATED);
        sciencePlanRepository.save(sp);
        return "Invalidate Science Plan Succeed ID: " + planId;
    }
    
    
    
    
    // public String validateSciencePlan(int planId) {
    //     Optional<SciencePlan> optionalPlan = sciencePlanRepository.findById(planId);
    //     if (!optionalPlan.isPresent()) {
    //         return "Science Plan not found.";
    //     }

    //     SciencePlan sp = optionalPlan.get();
        
    //     if (sp == null) {
    //         return "Science Plan not found.";
    //     }
    
    //     if (sp.getStatus() != SciencePlan.Status.SUBMITTED) {
    //         return "Science Plan is not in SUBMITTED status, cannot validate.";
    //     }

    //     if (!isSciencePlanValid(sp)) {
    //         sp.setStatus(SciencePlan.Status.INVALIDATED);
    //         sciencePlanRepository.save(sp);
    //         return "Validation failed. Plan INVALIDATED.";
    //     }

    //     sp.setStatus(SciencePlan.Status.VALIDATED);
    //     sciencePlanRepository.save(sp);
    //     return "Validate Science Plan Succeed ID: " + planId;
    // }
    

    // private boolean isSciencePlanValid(SciencePlan plan) {
    //     if (plan.getCreator() == null || 
    //         plan.getFunding() <= 0 || 
    //         plan.getObjectives() == null || 
    //         plan.getStartDate() == null || 
    //         plan.getEndDate() == null || 
    //         plan.getTelescope() == null || 
    //         plan.getTarget() == null) {
    //         return false;
    //     }

    //     List<DataProcRequirement> requirements = plan.getDataProcRequirements();
    //     if (requirements == null || requirements.isEmpty()) {
    //         return false;
    //     }
        
    //     return requirements.stream().allMatch(DataProcRequirement::isValid);
    // }


}
