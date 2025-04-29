package th.ac.mahidol.ict.gemini5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import th.ac.mahidol.ict.gemini5.model.SciencePlan;

@Repository
public interface SciencePlanRepository extends JpaRepository<SciencePlan, Integer> {
    List<SciencePlan> findByStatus(SciencePlan.Status status);
}
