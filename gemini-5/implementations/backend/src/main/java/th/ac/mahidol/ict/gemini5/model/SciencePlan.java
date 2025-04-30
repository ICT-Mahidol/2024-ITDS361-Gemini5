package th.ac.mahidol.ict.gemini5.model;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "science_plan")
public class SciencePlan {

    @Id
    @JsonProperty("planNo")
    private int planID;
    
    private String creator;
    private String submitter;

    @JsonProperty("fundingInUSD")
    private double funding;
    
    private String objectives;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;
    
    @JsonProperty("telescopeLocation")
    private String telescopeAssigned;

    @JsonProperty("starSystem")
    private String target;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "science_plan_id")
    private List<DataProcRequirement> dataProcRequirements; 

    @Enumerated(EnumType.STRING)
    private Status status;
    
    public SciencePlan() {}

    public SciencePlan(int planID, String creator, String submitter, double funding, 
                        String objectives, Date startDate, Date endDate,
                        String telescopeAssigned, String target, Status status) {
        this.planID = planID;
        this.creator = creator;
        this.submitter = submitter;
        this.funding = funding;
        this.objectives = objectives;
        this.startDate = startDate;
        this.endDate = endDate;
        this.telescopeAssigned = telescopeAssigned;
        this.target = target;
        this.status = status;
    }

    
    public int getPlanID() { 
        return planID; 
    }
    public void setPlanID(int planID) { 
        this.planID = planID; 
    }

    public String getCreator() { 
        return creator; 
    }
    public void setCreator(String creator) { 
        this.creator = creator; 
    }

    public String getSubmitter() { 
        return submitter; 
    }
    public void setSubmitter(String submitter) { 
        this.submitter = submitter; 
    }

    public double getFunding() { 
        return funding; 
    }
    public void setFunding(double funding) { 
        this.funding = funding; 
    }

    public String getObjectives() { 
        return objectives; 
    }
    public void setObjectives(String objectives) { 
        this.objectives = objectives; 
    }

    public Date getStartDate() { 
        return startDate; 
    }
    public void setStartDate(Date startDate) { 
        this.startDate = startDate; 
    }

    public Date getEndDate() { 
        return endDate; 
    }
    public void setEndDate(Date endDate) { 
        this.endDate = endDate; 
    }

    public String getTelescope() { 
        return telescopeAssigned; 
    }
    public void setTelescope(String telescopeAssigned) { 
        this.telescopeAssigned = telescopeAssigned; 
    }

    public String getTarget() { 
        return target; 
    }
    public void setTarget(String target) { 
        this.target = target; 
    }

    public List<DataProcRequirement> getDataProcRequirements() {
        return dataProcRequirements;
    }
    public void setDataProcRequirements(List<DataProcRequirement> dataProcRequirements) {
        this.dataProcRequirements = dataProcRequirements;
    }

    public enum Status {
        SAVED, CREATED, TESTED, SUBMITTED, VALIDATED, RUNNING, INVALIDATED, COMPLETE, CANCELLED
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    

}
