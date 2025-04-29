package th.ac.mahidol.ict.gemini5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.mahidol.ict.gemini5.model.ErrorLog;
import th.ac.mahidol.ict.gemini5.repository.ErrorLogRepository;

import java.time.LocalDateTime;

@Service
public class ErrorLogService {

    private final ErrorLogRepository errorLogRepository;

    @Autowired
    public ErrorLogService(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    public void logError(Exception ex, Long planId) {
        ErrorLog error = new ErrorLog();
        error.setErrorMessage(ex.getMessage());
        error.setStackTrace(getShortStackTrace(ex));  // ⬅️ เปลี่ยนตรงนี้
        error.setTimestamp(LocalDateTime.now());
        error.setPlanId(planId);
        errorLogRepository.save(error);
    }

    // ตัด StackTrace ให้สั้น
    private String getShortStackTrace(Exception ex) {
        StackTraceElement[] trace = ex.getStackTrace();
        StringBuilder sb = new StringBuilder();
        int limit = Math.min(1, trace.length);
        for (int i = 0; i < limit; i++) {
            sb.append(trace[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
