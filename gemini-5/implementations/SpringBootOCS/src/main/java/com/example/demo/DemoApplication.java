package com.example.demo;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.example.MySciencePlan;
import edu.gemini.app.ocs.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


@SpringBootApplication
public class DemoApplication {

    private static OCS ocs = new OCS(true);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        // execute();

        createSciencePlans();
        getSciencePlanById(2);
        updateSciencePlanStatus();
        getAllSciencePlans();
        collectAstronomicalData();
        // createObservingProgram();

    }

    public static void createSciencePlans() {
        System.out.println("\nCreating Science Plans...");
    
        MySciencePlan sp3 = new MySciencePlan();
        sp3.setCreator("Freja");
        sp3.setSubmitter("Ana");
        sp3.setFundingInUSD(1000);
        sp3.setObjectives("Study the Auriga star system.");
        sp3.setStarSystem(StarSystem.CONSTELLATIONS.Auriga);
        sp3.setStartDate("22/04/2021 23:00:00");
        sp3.setEndDate("23/04/2021 02:00:00");
        sp3.setTelescopeLocation(SciencePlan.TELESCOPELOC.CHILE);
        sp3.setDataProcRequirements(new DataProcRequirement("JPEG", "Low", "Color", 11, 10, 5, 0, 7, 0, 0, 0, 10, 8));
        ocs.createSciencePlan(sp3);
    
        MySciencePlan sp4 = new MySciencePlan();
        sp4.setCreator("Ashe");
        sp4.setSubmitter("Bastion");
        sp4.setFundingInUSD(2500);
        sp4.setObjectives("Observe Betelgeuse for supernova potential.");
        sp4.setStarSystem(StarSystem.CONSTELLATIONS.Orion);
        sp4.setStartDate("10/01/2023 21:00:00");
        sp4.setEndDate("11/01/2023 03:00:00");
        sp4.setTelescopeLocation(SciencePlan.TELESCOPELOC.HAWAII);
        sp4.setDataProcRequirements(new DataProcRequirement("FITS", "High", "Raw", 14, 12, 10, 2, 9, 1, 1, 1, 15, 12));
        ocs.createSciencePlan(sp4);
    
        MySciencePlan sp5 = new MySciencePlan();
        sp5.setCreator("Cassidy");
        sp5.setSubmitter("Doomfist");
        sp5.setFundingInUSD(1800);
        sp5.setObjectives("Infrared survey of Sagittarius A*.");
        sp5.setStarSystem(StarSystem.CONSTELLATIONS.Sagittarius);
        sp5.setStartDate("05/03/2022 01:00:00");
        sp5.setEndDate("05/03/2022 05:00:00");
        sp5.setTelescopeLocation(SciencePlan.TELESCOPELOC.HAWAII);
        sp5.setDataProcRequirements(new DataProcRequirement("TIFF", "Medium", "IR Enhanced", 10, 9, 8, 0, 6, 0, 0, 1, 12, 10));
        ocs.createSciencePlan(sp5);
    
        MySciencePlan sp6 = new MySciencePlan();
        sp6.setCreator("Genji");
        sp6.setSubmitter("Hanzo");
        sp6.setFundingInUSD(3000);
        sp6.setObjectives("Monitor Alpha Centauri system for exoplanets.");
        sp6.setStarSystem(StarSystem.CONSTELLATIONS.Centaurus);
        sp6.setStartDate("01/07/2024 20:00:00");
        sp6.setEndDate("02/07/2024 04:00:00");
        sp6.setTelescopeLocation(SciencePlan.TELESCOPELOC.CHILE);
        sp6.setDataProcRequirements(new DataProcRequirement("JPEG", "Low", "Color", 9, 8, 4, 0, 5, 0, 0, 0, 8, 7));
        ocs.createSciencePlan(sp6);
    
        MySciencePlan sp7 = new MySciencePlan();
        sp7.setCreator("Illari");
        sp7.setSubmitter("Juno");
        sp7.setFundingInUSD(2200);
        sp7.setObjectives("Observe Andromeda Galaxy in multiple bands.");
        sp7.setStarSystem(StarSystem.CONSTELLATIONS.Andromeda);
        sp7.setStartDate("15/11/2022 19:30:00");
        sp7.setEndDate("16/11/2022 01:30:00");
        sp7.setTelescopeLocation(SciencePlan.TELESCOPELOC.HAWAII);
        sp7.setDataProcRequirements(new DataProcRequirement("PNG", "High", "Multi-Band", 13, 11, 7, 1, 8, 1, 0, 0, 14, 11));
        ocs.createSciencePlan(sp7);

        MySciencePlan sp8 = new MySciencePlan();
        sp8.setCreator("Kiriko");
        sp8.setSubmitter("Mercy");
        sp8.setFundingInUSD(2000);
        sp8.setObjectives("Infrared survey of Sagittarius A*.");
        sp8.setStarSystem(StarSystem.CONSTELLATIONS.Sagittarius);
        sp8.setStartDate("10/10/2022 02:00:00");
        sp8.setEndDate("11/10/2022 06:30:00");
        sp8.setTelescopeLocation(SciencePlan.TELESCOPELOC.HAWAII);
        sp8.setDataProcRequirements(new DataProcRequirement("JPEG", "Low", "Color", 9, 8, 4, 0, 5, 0, 0, 0, 8, 7));
        ocs.createSciencePlan(sp8);

        MySciencePlan sp9 = new MySciencePlan();
        sp9.setCreator("Mei");
        sp9.setSubmitter("Sojourn");
        sp9.setFundingInUSD(2800);
        sp9.setObjectives("Study the effects of gamma-ray bursts on surrounding space.");
        sp9.setStarSystem(StarSystem.CONSTELLATIONS.Perseus);
        sp9.setStartDate("20/09/2023 12:00:00");
        sp9.setEndDate("21/09/2023 06:00:00");
        sp9.setTelescopeLocation(SciencePlan.TELESCOPELOC.CHILE);
        sp9.setDataProcRequirements(new DataProcRequirement("PNG", "High", "Multi-Band", 14, 12, 8, 2, 10, 2, 1, 1, 16, 14));
        ocs.createSciencePlan(sp9);

        MySciencePlan sp10 = new MySciencePlan();
        sp10.setCreator("Winston");
        sp10.setSubmitter("Zarya");
        sp10.setFundingInUSD(3500);
        sp10.setObjectives("Monitor asteroid belt for potential threats to Earth.");
        sp10.setStarSystem(StarSystem.CONSTELLATIONS.Andromeda);
        sp10.setStartDate("15/08/2024 22:00:00");
        sp10.setEndDate("16/08/2024 04:00:00");
        sp10.setTelescopeLocation(SciencePlan.TELESCOPELOC.HAWAII);
        sp10.setDataProcRequirements(new DataProcRequirement("TIFF", "Medium", "IR Enhanced", 12, 10, 9, 1, 8, 1, 1, 1, 13, 11));
        ocs.createSciencePlan(sp10);

        MySciencePlan sp11 = new MySciencePlan();
        sp11.setCreator("Tracer");
        sp11.setSubmitter("Sombra");
        sp11.setFundingInUSD(2200);
        sp11.setObjectives("Investigate the presence of water on exoplanets in the Lyra constellation.");
        sp11.setStarSystem(StarSystem.CONSTELLATIONS.Lyra);
        sp11.setStartDate("10/05/2025 18:30:00");
        sp11.setEndDate("11/05/2025 03:00:00");
        sp11.setTelescopeLocation(SciencePlan.TELESCOPELOC.CHILE);
        sp11.setDataProcRequirements(new DataProcRequirement("JPEG", "Low", "Color", 15, 12, 6, 1, 9, 1, 0, 0, 14, 12));
        ocs.createSciencePlan(sp11);

        MySciencePlan sp12 = new MySciencePlan();
        sp12.setCreator("Reaper");
        sp12.setSubmitter("Reinhardt");
        sp12.setFundingInUSD(2700);
        sp12.setObjectives("Analyze spectral signatures of exoplanets.");
        sp12.setStarSystem(StarSystem.CONSTELLATIONS.Pisces);
        sp12.setStartDate("05/12/2024 21:00:00");
        sp12.setEndDate("06/12/2024 04:00:00");
        sp12.setTelescopeLocation(SciencePlan.TELESCOPELOC.CHILE);
        sp12.setDataProcRequirements(new DataProcRequirement("JPEG", "Medium", "Color", 10, 8, 5, 1, 7, 1, 0, 0, 11, 9));
        ocs.createSciencePlan(sp12);

        MySciencePlan sp13 = new MySciencePlan();
        sp13.setCreator("Roadhog");
        sp13.setSubmitter("Orisa");
        sp13.setFundingInUSD(3200);
        sp13.setObjectives("Survey the Sculptor Dwarf Galaxy.");
        sp13.setStarSystem(StarSystem.CONSTELLATIONS.Sculptor);
        sp13.setStartDate("15/01/2025 20:00:00");
        sp13.setEndDate("16/01/2025 02:00:00");
        sp13.setTelescopeLocation(SciencePlan.TELESCOPELOC.HAWAII);
        sp13.setDataProcRequirements(new DataProcRequirement("PNG", "High", "Multi-Band", 13, 11, 7, 1, 8, 1, 0, 0, 14, 11));
        ocs.createSciencePlan(sp13);

        MySciencePlan sp14 = new MySciencePlan();
        sp14.setCreator("Junkrat");
        sp14.setSubmitter("Hazard");
        sp14.setFundingInUSD(2100);
        sp14.setObjectives("Observe comet trajectories near Jupiter.");
        sp14.setStarSystem(StarSystem.CONSTELLATIONS.Cancer);
        sp14.setStartDate("28/02/2025 22:00:00");
        sp14.setEndDate("01/03/2025 03:00:00");
        sp14.setTelescopeLocation(SciencePlan.TELESCOPELOC.CHILE);
        sp14.setDataProcRequirements(new DataProcRequirement("TIFF", "Low", "IR Enhanced", 12, 10, 9, 1, 8, 1, 1, 1, 13, 11));
        ocs.createSciencePlan(sp14);

        MySciencePlan sp15 = new MySciencePlan();
        sp15.setCreator("D.VA");
        sp15.setSubmitter("Moira");
        sp15.setFundingInUSD(2600);
        sp15.setObjectives("Mapping dark matter distributions.");
        sp15.setStarSystem(StarSystem.CONSTELLATIONS.Draco);
        sp15.setStartDate("08/03/2025 23:00:00");
        sp15.setEndDate("09/03/2025 04:30:00");
        sp15.setTelescopeLocation(SciencePlan.TELESCOPELOC.HAWAII);
        sp15.setDataProcRequirements(new DataProcRequirement("JPEG", "High", "Raw", 14, 12, 10, 2, 9, 1, 1, 1, 15, 12));
        ocs.createSciencePlan(sp15);

        MySciencePlan sp16 = new MySciencePlan();
        sp16.setCreator("Widowmaker");
        sp16.setSubmitter("Pharah");
        sp16.setFundingInUSD(3300);
        sp16.setObjectives("Survey binary star systems for gravitational interactions.");
        sp16.setStarSystem(StarSystem.CONSTELLATIONS.Gemini);
        sp16.setStartDate("20/04/2025 19:30:00");
        sp16.setEndDate("21/04/2025 03:00:00");
        sp16.setTelescopeLocation(SciencePlan.TELESCOPELOC.CHILE);
        sp16.setDataProcRequirements(new DataProcRequirement("FITS", "Medium", "Color", 11, 9, 6, 1, 7, 1, 1, 1, 12, 10));
        ocs.createSciencePlan(sp16);

    
        System.out.println("✅ Created science plans successfully.");
    }

    public static SciencePlan getSciencePlanById(int id) {
        System.out.println("\nGet a science plan by ID");
        SciencePlan sp2 = ocs.getSciencePlanByNo(id);
        System.out.println(sp2);
        return sp2;
    }

    public static void updateSciencePlanStatus() {
        System.out.println("\nUpdate a science plan status...");

        ocs.updateSciencePlanStatus(1, SciencePlan.STATUS.SUBMITTED);
        System.out.println(ocs.getSciencePlanByNo(1));

        ocs.updateSciencePlanStatus(2, SciencePlan.STATUS.COMPLETE);
        System.out.println(ocs.getSciencePlanByNo(2));
    
        ocs.updateSciencePlanStatus(3, SciencePlan.STATUS.VALIDATED);
        System.out.println(ocs.getSciencePlanByNo(3));

        ocs.updateSciencePlanStatus(4, SciencePlan.STATUS.TESTED);
        System.out.println(ocs.getSciencePlanByNo(4));

        ocs.updateSciencePlanStatus(5, SciencePlan.STATUS.VALIDATED);
        System.out.println(ocs.getSciencePlanByNo(5));

        ocs.updateSciencePlanStatus(6, SciencePlan.STATUS.SUBMITTED);
        System.out.println(ocs.getSciencePlanByNo(6));

        ocs.updateSciencePlanStatus(7, SciencePlan.STATUS.RUNNING);
        System.out.println(ocs.getSciencePlanByNo(7));

        ocs.updateSciencePlanStatus(8, SciencePlan.STATUS.COMPLETE);
        System.out.println(ocs.getSciencePlanByNo(8));

        ocs.updateSciencePlanStatus(9, SciencePlan.STATUS.INVALIDATED);
        System.out.println(ocs.getSciencePlanByNo(9));

        ocs.updateSciencePlanStatus(10, SciencePlan.STATUS.CANCELLED);
        System.out.println(ocs.getSciencePlanByNo(10));

        ocs.updateSciencePlanStatus(11, SciencePlan.STATUS.VALIDATED);
        System.out.println(ocs.getSciencePlanByNo(11));

        ocs.updateSciencePlanStatus(12, SciencePlan.STATUS.SAVED);
        System.out.println(ocs.getSciencePlanByNo(12));

        ocs.updateSciencePlanStatus(13, SciencePlan.STATUS.TESTED);
        System.out.println(ocs.getSciencePlanByNo(13));

        ocs.updateSciencePlanStatus(14, SciencePlan.STATUS.SUBMITTED);
        System.out.println(ocs.getSciencePlanByNo(14));

        ocs.updateSciencePlanStatus(15, SciencePlan.STATUS.RUNNING);
        System.out.println(ocs.getSciencePlanByNo(15));

        ocs.updateSciencePlanStatus(16, SciencePlan.STATUS.COMPLETE);
        System.out.println(ocs.getSciencePlanByNo(16));

        System.out.println("✅ Statuses assigned.");
    }

    public static void getAllSciencePlans() {
        System.out.println("\nGet all the science plans");
        ArrayList<SciencePlan> sciencePlans = ocs.getAllSciencePlans();
        for (SciencePlan sp : sciencePlans) {
            System.out.println(sp);
        }
    }


    public static void collectAstronomicalData() {
        System.out.println("\nGet the astronomical data from complete science plan");
        System.out.println(ocs.getSciencePlanByNo(2));
        AstronomicalData astroData = null;
        try {
            astroData = ocs.getAstronomicalData(ocs.getSciencePlanByNo(2));
            if (astroData != null) {
                ArrayList<BufferedImage> images = null;
                images = astroData.getAllImages();
                System.out.println("Images = " + images.size());
            } else {
                System.out.println("No astronomical data collected.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public static void collectAstronomicalData() {
    //     System.out.println("\nGet the astronomical data from complete science plan");

    //     // ดึงรายการของ SciencePlan ที่มีสถานะเป็น COMPLETE
    //     List<SciencePlan> completePlans = ocs.getAllSciencePlans().stream()
    //             .filter(plan -> plan.getStatus() == SciencePlan.STATUS.COMPLETE)
    //             .collect(Collectors.toList());

    //     if (completePlans.isEmpty()) {
    //         System.out.println("No complete science plans found.");
    //         return;
    //     }

    //     for (SciencePlan plan : completePlans) {
    //         try {
    //             AstronomicalData astroData = ocs.getAstronomicalData(plan);
    //             if (astroData != null) {
    //                 ArrayList<BufferedImage> images = astroData.getAllImages();
    //                 System.out.println("Images = " + images.size());
    //             } else {
    //                 System.out.println("No astronomical data collected for Science Plan ID: " + plan.getPlanNo());
    //             }
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //             System.out.println("Error collecting astronomical data for Science Plan ID: " + plan.getPlanNo());
    //         }
    //     }
    // }

    public static void createObservingProgram() {
        System.out.println("\nCreate an observing program");
        ObservingProgramConfigs.FoldMirrorType[] foldMirrorTypes = ObservingProgramConfigs.getFoldMirrorType();
        ObservingProgramConfigs.CalibrationUnit[] calibrationunits = ObservingProgramConfigs.getCalibrationUnit();
        ObservingProgramConfigs.LightType[] lightTypes = ObservingProgramConfigs.getLightType();
        TelePositionPair[] telePositionPairs = new TelePositionPair[5];
        TelePositionPair telePositionPair1 = new TelePositionPair(35.0, 40.0);
        telePositionPairs[0] = telePositionPair1;
        TelePositionPair telePositionPair2 = new TelePositionPair(50.0, 60.0);
        telePositionPairs[1] = telePositionPair2;
        TelePositionPair telePositionPair3 = new TelePositionPair(80.0, 15.0);
        telePositionPairs[2] = telePositionPair3;
        TelePositionPair telePositionPair4 = new TelePositionPair(90.0, 10.0);
        telePositionPairs[3] = telePositionPair4;
        TelePositionPair telePositionPair5 = new TelePositionPair(20.0, 20.0);
        telePositionPairs[4] = telePositionPair5;

        SciencePlan mySP = getSciencePlanById(2);
        ObservingProgram op = ocs.createObservingProgram(mySP, "GNZ",
                1.9, 7, 33, foldMirrorTypes[0],
                2, calibrationunits[1], lightTypes[1], telePositionPairs);
        System.out.println(op);
        op.validateObservingCondition(op);
        System.out.println(op);
        ocs.saveObservingProgram(op);

        ArrayList<SciencePlan> sciencePlans = ocs.getAllSciencePlans();

        for (SciencePlan sp : sciencePlans) {
            System.out.println(sp);
            System.out.println(ocs.getObservingProgramBySciencePlan(sp));
        }
    }
    

    // public static void getAllSciencePlans() {
    //     // Case 1: Get all the science plans
    //     System.out.println("\nCase 1: Get all the science plans");
    //     ArrayList<SciencePlan> sciencePlans = ocs.getAllSciencePlans();
    //     for (SciencePlan sp : sciencePlans) {
    //         System.out.println(sp);
    //     }
    // }

    // public static SciencePlan getSciencePlanById(int id) {
    //     // Case 2: Get a science plan by ID
    //     System.out.println("\nCase 2: Get a science plan by ID");
    //     SciencePlan sp2 = ocs.getSciencePlanByNo(id);
    //     System.out.println(sp2);
    //     return sp2;
    // }

    // public static void createSciencePlan() {
    //     // Case 3: Create a new science plan
    //     System.out.println("\nCase 3: Create a new science plan");
    //     MySciencePlan mySP = new MySciencePlan();
    //     mySP.setCreator("Morakot Choetkiertikul");
    //     mySP.setSubmitter("Chaiyong Ragkhitwetsagul");
    //     mySP.setFundingInUSD(1000);
    //     mySP.setObjectives("To study the Auriga star system.");
    //     mySP.setStarSystem(StarSystem.CONSTELLATIONS.Auriga);
    //     mySP.setStartDate("22/04/2021 23:00:00");
    //     mySP.setTelescopeLocation(SciencePlan.TELESCOPELOC.CHILE);
    //     mySP.setEndDate("23/04/2021 02:00:00");
    //     DataProcRequirement dpr1 =
    //             new DataProcRequirement("JPEG", "Low", "Color mode",
    //                     11, 10, 5, 0, 7, 0,
    //                     0, 0, 10, 8);
    //     mySP.setDataProcRequirements(dpr1);
    //     // submit it to the OCS system
    //     ocs.createSciencePlan(mySP);
    //     System.out.println(ocs.getAllSciencePlans());
    // }

    // public static void updateSciencePlanStatus() {
    //     // Case 4: Update a science plan status
    //     System.out.println("\nCase 4: Update a science plan status");
    //     ocs.updateSciencePlanStatus(3, SciencePlan.STATUS.COMPLETE);
    //     System.out.println(ocs.getSciencePlanByNo(3));
    // }

    // public static void collectAstronomicalData() {
    //     // Case 5: Get the astronomical data from complete science plan
    //     System.out.println("\nCase 5: Get the astronomical data from complete science plan");
    //     System.out.println(ocs.getSciencePlanByNo(3));
    //     AstronomicalData astroData = null;
    //     try {
    //         astroData = ocs.getAstronomicalData(ocs.getSciencePlanByNo(3));
    //         if (astroData != null) {
    //             ArrayList<BufferedImage> images = null;
    //             images = astroData.getAllImages();
    //             System.out.println("Images = " + images.size());
    //         } else {
    //             System.out.println("No astronomical data collected.\n");
    //         }
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // public static void removeASciencePlan() {
    //     // Case 6: Remove a science plan
    //     System.out.println("\nCase 6: Remove a science plan");
    //     ocs.deleteSciencePlanByNo(3);
    //     System.out.println(ocs.getAllSciencePlans());
    // }

    // public static void executeCommandLineCommands() {
    //     // Case 7: Execute a command line
    //     System.out.println("\nCase 7: Execute a Gemini command line's command");
    //     // Execute the command to get the Gemini system version
    //     System.out.println(ocs.executeCommand("GetVersion"));
    //     // Execute the command to get the status of the Gemini system
    //     System.out.println(ocs.executeCommand("GetStatus"));
    //     // Execute the command to run the system test
    //     System.out.println(ocs.executeCommand("RunTest"));
    //     // Send command to the virtual telescope
    //     System.out.println(ocs.executeCommand("START"));
    //     System.out.println(ocs.executeCommand("UP"));
    //     System.out.println(ocs.executeCommand("UP"));
    //     System.out.println(ocs.executeCommand("LEFT"));
    //     System.out.println(ocs.executeCommand("LEFT"));
    //     System.out.println(ocs.executeCommand("FOCUS"));
    //     System.out.println(ocs.executeCommand("TAKE_PHOTO"));
    //     System.out.println(ocs.executeCommand("STOP"));
    //     // Execute an unavailable command
    //     System.out.println(ocs.executeCommand("A"));
    // }

    // public static void installRemovePhysicalUnits() {
    //     // Case 8: Install and remove the physical units in the operation tables
    //     System.out.println("\nCase 8: Install and remove the physical units in the operation tables");
    //     System.out.println("OPERATING TABLE");
    //     System.out.println(ocs.getConfigurations());
    //     boolean success = ocs.addConfiguration("My Own Physical Unit");
    //     System.out.println("Adding status: " + success);
    //     System.out.println(ocs.getConfigurations());
    //     success = ocs.removeConfiguration(5);
    //     System.out.println("Removing status: " + success);
    //     System.out.println(ocs.getConfigurations());
    // }

    // public static void accessLiveView() {
    //     // Case 9: Access live view of telescope
    //     System.out.println("\nCase 9: Access live view of telescope");
    //     try {
    //         System.out.println(ocs.accessTelescopeLiveView());
    //     } catch (IOException ie) {
    //         ie.printStackTrace();
    //     }
    // }

    // public static void testSciencePlan() {
    //     // Case 10: Test science plan
    //     System.out.println("\nCase 10: Test a science plan");
    //     System.out.println(ocs.testSciencePlan(ocs.getSciencePlanByNo(2)));
    //     System.out.println(ocs.getAllSciencePlans());
    // }

    // public static void createObservingProgram() {
    //     // Case 11: Create observing program
    //     System.out.println("\nCase 11: Create an observing program");
    //     ObservingProgramConfigs.FoldMirrorType[] foldMirrorTypes = ObservingProgramConfigs.getFoldMirrorType();
    //     ObservingProgramConfigs.CalibrationUnit[] calibrationunits = ObservingProgramConfigs.getCalibrationUnit();
    //     ObservingProgramConfigs.LightType[] lightTypes = ObservingProgramConfigs.getLightType();
    //     TelePositionPair[] telePositionPairs = new TelePositionPair[5];
    //     TelePositionPair telePositionPair1 = new TelePositionPair(35.0, 40.0);
    //     telePositionPairs[0] = telePositionPair1;
    //     TelePositionPair telePositionPair2 = new TelePositionPair(50.0, 60.0);
    //     telePositionPairs[1] = telePositionPair2;
    //     TelePositionPair telePositionPair3 = new TelePositionPair(80.0, 15.0);
    //     telePositionPairs[2] = telePositionPair3;
    //     TelePositionPair telePositionPair4 = new TelePositionPair(90.0, 10.0);
    //     telePositionPairs[3] = telePositionPair4;
    //     TelePositionPair telePositionPair5 = new TelePositionPair(20.0, 20.0);
    //     telePositionPairs[4] = telePositionPair5;

    //     SciencePlan mySP = getSciencePlanById(2);
    //     ObservingProgram op = ocs.createObservingProgram(mySP, "GNZ",
    //             1.9, 7, 33, foldMirrorTypes[0],
    //             2, calibrationunits[1], lightTypes[1], telePositionPairs);
    //     System.out.println(op);
    //     op.validateObservingCondition(op);
    //     System.out.println(op);
    //     ocs.saveObservingProgram(op);

    //     ArrayList<SciencePlan> sciencePlans = ocs.getAllSciencePlans();

    //     for (SciencePlan sp : sciencePlans) {
    //         System.out.println(sp);
    //         System.out.println(ocs.getObservingProgramBySciencePlan(sp));
    //     }
    // }

    // public static void manageObservationSchedule() {
    //     // Case 12: manage observation schedule
    //     System.out.println("\nCase 12: manage observation schedule");
    //     Calendar cal = Calendar.getInstance();
    //     cal.set(2023, 11, 21);
    //     Date date = cal.getTime();
    //     System.out.println(ocs.addUnavailableDate(date));
    //     System.out.println(ocs.deleteUnavailableDate(date));
    //     System.out.println(ocs.getAllObservationSchedule());

    //     // Case 13: remove astronomical data
    //     System.out.println("\nCase 13: Remove an astronomical data");
    //     try {
    //         AstronomicalData astroData = ocs.removeAstronomicalData(ocs.getSciencePlanByNo(1),0);
    //     } catch (IOException e) {
    //         throw new RuntimeException(e);
    //     }
    // }

    // public static void updateConfiguration() {
    //     System.out.println("\nCase 14: Get and update the configuration");
    //     // Case 14: update configuration
    //     try {
    //         ocs.getDefaultConfiguration();
    //         ocs.getCurrentConfiguration();
    //         String msgSts = ocs.updateConfiguration();
    //         System.out.println(msgSts);
    //     } catch (IOException e) {
    //         throw new RuntimeException(e);
    //     }
    // }

    // public static void execute() {
    //     getAllSciencePlans();
    //     getSciencePlanById(2);
    //     createSciencePlan();
    //     updateSciencePlanStatus();
    //     collectAstronomicalData();
    //     removeASciencePlan();
    //     executeCommandLineCommands();
    //     installRemovePhysicalUnits();
    //     accessLiveView();
    //     testSciencePlan();
    //     createObservingProgram();
    //     manageObservationSchedule();
    //     updateConfiguration();
    // }

}
