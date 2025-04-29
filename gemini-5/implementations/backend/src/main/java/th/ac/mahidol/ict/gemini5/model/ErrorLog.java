package th.ac.mahidol.ict.gemini5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

@Entity
public class ErrorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long planId;

    @Column(length = 1000)
    private String errorMessage;

    @Column(length = 1000)
    private String stackTrace;
    private LocalDateTime timestamp;

    // ✅ Default constructor (จำเป็นสำหรับ JPA)
    public ErrorLog() {}

    // ✅ Constructor แบบกำหนดค่า
    public ErrorLog(String errorMessage, String stackTrace, LocalDateTime timestamp, Long planId) {
        this.planId = planId;
        this.errorMessage = errorMessage;
        this.stackTrace = stackTrace;
        this.timestamp = timestamp;
    }

    // ✅ Getter และ Setter
    public Long getId() {
        return id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }
}
