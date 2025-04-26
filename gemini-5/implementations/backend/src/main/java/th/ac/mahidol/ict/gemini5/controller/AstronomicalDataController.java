package th.ac.mahidol.ict.gemini5.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.ac.mahidol.ict.gemini5.model.AstronomicalData;
import th.ac.mahidol.ict.gemini5.service.AstronomicalDataService;

@RequestMapping("/ocs")
@RestController
@CrossOrigin
public class AstronomicalDataController {

    private final AstronomicalDataService astroDataService;

    public AstronomicalDataController(AstronomicalDataService astroDataService) {
        this.astroDataService = astroDataService;
    }

}
