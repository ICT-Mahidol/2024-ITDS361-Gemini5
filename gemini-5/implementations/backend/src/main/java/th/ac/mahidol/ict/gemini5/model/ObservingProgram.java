package th.ac.mahidol.ict.gemini5.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ObservingProgram {

    @Id
    private int planID; // ใช้ planID จาก SciencePlan เป็น Primary Key
    private String geminiLocation;
    private String opticsPrimary;
    private double fStop;
    private double opticsSecondaryRMS;
    private double scienceFoldMirrorDegree;
    private String scienceFoldMirrorType;
    private String moduleContent;
    private String calibrationUnit;
    private String lightType;
    private double[] telescopePositionPair;

    // Getters and Setters
    public int getPlanID() { return planID; }
    public void setPlanID(int planID) { this.planID = planID; }

    public String getGeminiLocation() { return geminiLocation; }
    public void setGeminiLocation(String geminiLocation) { this.geminiLocation = geminiLocation; }

    public String getOpticsPrimary() { return opticsPrimary; }
    public void setOpticsPrimary(String opticsPrimary) { this.opticsPrimary = opticsPrimary; }

    public double getFStop() { return fStop; }
    public void setFStop(double fStop) { this.fStop = fStop; }

    public double getOpticsSecondaryRMS() { return opticsSecondaryRMS; }
    public void setOpticsSecondaryRMS(double opticsSecondaryRMS) { this.opticsSecondaryRMS = opticsSecondaryRMS; }

    public double getScienceFoldMirrorDegree() { return scienceFoldMirrorDegree; }
    public void setScienceFoldMirrorDegree(double scienceFoldMirrorDegree) { this.scienceFoldMirrorDegree = scienceFoldMirrorDegree; }

    public String getScienceFoldMirrorType() { return scienceFoldMirrorType; }
    public void setScienceFoldMirrorType(String scienceFoldMirrorType) { this.scienceFoldMirrorType = scienceFoldMirrorType; }

    public String getModuleContent() { return moduleContent; }
    public void setModuleContent(String moduleContent) { this.moduleContent = moduleContent; }

    public String getCalibrationUnit() { return calibrationUnit; }
    public void setCalibrationUnit(String calibrationUnit) { this.calibrationUnit = calibrationUnit; }

    public String getLightType() { return lightType; }
    public void setLightType(String lightType) { this.lightType = lightType; }

    public double[] getTelescopePositionPair() { return telescopePositionPair; }
    public void setTelescopePositionPair(double[] telescopePositionPair) { this.telescopePositionPair = telescopePositionPair; }
}
