package com.example.demo;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.SciencePlan;
import edu.gemini.app.ocs.model.AstronomicalData;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ocs")
@CrossOrigin
public class DemoController {

    private final OCS ocs = new OCS();

    @GetMapping("/sp/all")
    public List<SciencePlan> getAllSciencePlans(@RequestParam(name = "status", required = false) String status) {
        List<SciencePlan> allPlans = ocs.getAllSciencePlans();
        if (status == null || status.isEmpty()) {
            return allPlans;
        }
        return allPlans.stream()
                .filter(plan -> plan.getStatus().toString().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }


    @GetMapping("/sp")
    public SciencePlan getSciencePlan(@RequestParam(name="id", required=false, defaultValue="1") int id) {
        return ocs.getSciencePlanByNo(Integer.valueOf(id));
    }

    @PostMapping("/sp")
    public SciencePlan createSciencePlan(@RequestBody SciencePlan sp) {
        String newPlanId = ocs.submitSciencePlan(sp);
        return ocs.getSciencePlanByNo(Integer.parseInt(newPlanId));
    }


    @PostMapping("/sp/run/{id}")
    public String runSciencePlan(@PathVariable("id") int id) {
        SciencePlan plan = ocs.getSciencePlanByNo(id);
        if (plan == null) {
            return "Science Plan ID " + id + " not found.";
        }

        if (plan.getStatus() != SciencePlan.STATUS.VALIDATED) {
            return "Science Plan ID " + id + " is not VALIDATED. Please validate the plan first.";
        }

        ocs.updateSciencePlanStatus(id, SciencePlan.STATUS.RUNNING);
        return "Science Plan ID " + id + " is now RUNNING.";
    }

    @PutMapping("/sp/status/{id}")
    public String updatePlanStatus(@PathVariable int id, @RequestParam String status) {
        SciencePlan plan = ocs.getSciencePlanByNo(id);
        if (plan == null) {
            return "Science Plan not found.";
        }

        try {
            SciencePlan.STATUS newStatus = SciencePlan.STATUS.valueOf(status.toUpperCase());
            ocs.updateSciencePlanStatus(id, newStatus);
            return "Status updated.";
        } catch (IllegalArgumentException e) {
            return "Invalid status.";
        }
    }

    // @GetMapping("/astrodata/sp/{planId}")
    // public ResponseEntity<AstronomicalData> getAstronomicalData(@PathVariable int planId) {
    //     AstronomicalData astronomicalData = ocs.getAstronomicalDataByPlanId(planId);
        
    //     if (astronomicalData != null) {
    //         return new ResponseEntity<>(astronomicalData, HttpStatus.OK);
    //     } else {
    //         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //     }
    // }


}
