package th.ac.mahidol.ict.gemini5.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import th.ac.mahidol.ict.gemini5.model.SciencePlan;
import th.ac.mahidol.ict.gemini5.service.OCSServiceClient;

@Service
public class GeminiFacade {

    private final OCSServiceClient ocsServiceClient;

    public GeminiFacade(OCSServiceClient ocsServiceClient) {
        this.ocsServiceClient = ocsServiceClient;
    }

    public List<SciencePlan> getAllSciencePlans() {
        return ocsServiceClient.getAllSciencePlans();
    }
    
    public List<SciencePlan> getSciencePlansByStatus(String status) {
        return ocsServiceClient.getSciencePlansFiltered(status);
    }

    public SciencePlan getSciencePlanById(int id) {
        return ocsServiceClient.getSciencePlanById(id);
    }

    public boolean executeSciencePlan(int planId) {
        SciencePlan plan = getSciencePlanById(planId);
        return "VALIDATED".equals(plan.getStatus().toString()) && ocsServiceClient.runSciencePlan(plan);
    }

    public boolean updatePlanStatus(int id, SciencePlan.Status status) {
        return ocsServiceClient.updateSciencePlanStatus(id, status);
    }
}
