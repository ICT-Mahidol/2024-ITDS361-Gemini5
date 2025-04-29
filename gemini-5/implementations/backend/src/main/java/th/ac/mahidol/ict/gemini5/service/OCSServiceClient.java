package th.ac.mahidol.ict.gemini5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import th.ac.mahidol.ict.gemini5.model.AstronomicalData;
import th.ac.mahidol.ict.gemini5.model.SciencePlan;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class OCSServiceClient {
    
    private final RestTemplate restTemplate;
    private final String ocsBaseUrl = "http://localhost:8081/ocs";

    @Autowired
    public OCSServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<SciencePlan> getAllSciencePlans() {
        SciencePlan[] plans = restTemplate.getForObject(
            ocsBaseUrl + "/sp/all", 
            SciencePlan[].class
        );
        return Arrays.asList(plans);
    }

    public List<SciencePlan> getSciencePlansFiltered(String status) {
        SciencePlan[] plans = restTemplate.getForObject(ocsBaseUrl + "/sp/all", SciencePlan[].class);
        if (status == null) return Arrays.asList(plans);

        return Arrays.stream(plans)
            .filter(p -> p.getStatus().toString().equalsIgnoreCase(status))
            .collect(Collectors.toList());
    }

    public SciencePlan getSciencePlanById(int id) {
        SciencePlan plan = restTemplate.getForObject(ocsBaseUrl + "/sp?id=" + id, SciencePlan.class);
        return plan;
    }

    public boolean runSciencePlan(SciencePlan plan) {
        try {
            String url = ocsBaseUrl + "/sp/run/" + plan.getPlanID();
            restTemplate.postForObject(url, null, String.class);
            return true;
        } catch (Exception e) {
            System.err.println("Failed to run science plan: " + e.getMessage());
            return false;
        }
    }

    public boolean updateSciencePlanStatus(int id, SciencePlan.Status status) {
        try {
            String url = ocsBaseUrl + "/sp/status/" + id + "?status=" + status.name();
            restTemplate.put(url, null);
            return true;
        } catch (HttpClientErrorException e) {
            return false;
        }
    }

    public List<String> fetchImageUrls(int sciencePlanId) {
        // จำลอง: สมมุติว่าเราเรียก API OCS ที่คืนมาเป็น URL List
        // จริงๆ ต้องต่อ API OCS ฝั่งคุณ แต่ตอนนี้ mock ไว้ก่อน
        return List.of(
            "https://gemini.edu/common/media/archives/images/wallpaper5/noirlab2212c.jpg",
            "https://gemini.edu/common/media/archives/images/wallpaper5/geminiann02010b.jpg"
        );
    }


    // public List<AstronomicalData> getAllAstronomicalData() {
    //     try {
    //         AstronomicalData[] data = restTemplate.getForObject(ocsBaseUrl + "/astrodata/all", AstronomicalData[].class);
    //         return Arrays.asList(data);
    //     } catch (Exception e) {
    //         return List.of(); 
    //     }
    // }

    // public AstronomicalData getAstronomicalDataById(int id) {
    //     try {
    //         return restTemplate.getForObject(ocsBaseUrl + "/astrodata/" + id, AstronomicalData.class);
    //     } catch (Exception e) {
    //         return null;
    //     }
    // }

}
