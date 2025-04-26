package th.ac.mahidol.ict.gemini5.model;

import java.util.List;

public class AstronomicalDataCollectRequest {
    
    private int sciencePlanId;
    private List<Integer> datasetId;

    public int getSciencePlanID() {
        return sciencePlanId;
    }
    public void setSciencePlanID(int sciencePlanId) {
        this.sciencePlanId = sciencePlanId;
    }

    public List<Integer> getDatasetID() {
        return datasetId;
    }
    public void setDatasetID(List<Integer> datasetId) {
        this.datasetId = datasetId;
    }
}
