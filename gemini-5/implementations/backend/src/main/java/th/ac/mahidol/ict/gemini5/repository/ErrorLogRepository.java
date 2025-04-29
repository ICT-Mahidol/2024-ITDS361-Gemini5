package th.ac.mahidol.ict.gemini5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.mahidol.ict.gemini5.model.ErrorLog;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
}
