package th.ac.mahidol.ict.gemini5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import th.ac.mahidol.ict.gemini5.model.ObservingProgram;

public interface ObservingProgramRepository extends JpaRepository<ObservingProgram, Integer> {
    // PlanID เป็น Primary Key
}
