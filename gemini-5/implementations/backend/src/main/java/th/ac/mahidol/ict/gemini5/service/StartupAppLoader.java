package th.ac.mahidol.ict.gemini5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import th.ac.mahidol.ict.gemini5.model.SciencePlan;

@Component
public class StartupAppLoader implements ApplicationRunner {

    private final SciencePlanService sciencePlanService;
    
    @Autowired
    public StartupAppLoader(SciencePlanService sciencePlanService) {
        this.sciencePlanService = sciencePlanService;
        
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<SciencePlan> saved = sciencePlanService.fetchAndSaveAllFromOCS();
        System.out.println("Fetched " + saved.size() + " science plans from OCS to DB.");
    }




}
