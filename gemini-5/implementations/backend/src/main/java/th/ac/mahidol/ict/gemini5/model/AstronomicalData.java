package th.ac.mahidol.ict.gemini5.model;

import java.util.List;


public class AstronomicalData {

    private int datasetID;
    private int planID;
    private String dataType;
    private List<String> imageName;
    private List<String> imageURL;


    public int getDatasetID() {
        return datasetID;
    }
    public void setDatasetID(int datasetID) {
        this.datasetID = datasetID;
    }

    public int getPlanID() {
        return planID;
    }
    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public String getDataType() {
        return dataType;
    }
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public List<String> getImageName() { 
        return imageName; 
    }
    public void setImageName(List<String> imageName) { 
        this.imageName = imageName; 
    }

    public List<String> getImageURL() { 
        return imageURL; 
    }
    public void setImageURL(List<String> imageURL) { 
        this.imageURL = imageURL; 
    }

}
