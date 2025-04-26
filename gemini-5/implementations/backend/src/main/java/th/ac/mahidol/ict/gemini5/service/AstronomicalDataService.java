package th.ac.mahidol.ict.gemini5.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.ac.mahidol.ict.gemini5.model.AstronomicalData;

@Service
public class AstronomicalDataService {

    private final OCSServiceClient ocsServiceClient;

     @Autowired
    public AstronomicalDataService(OCSServiceClient ocsServiceClient) {
        this.ocsServiceClient = ocsServiceClient;
    }
    
}
