package repository;

import entities.RatioData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatioDataRepo extends JpaRepository<RatioData, Long> {
    List<RatioData> findByTimestampIsBetween(long timestampStart, long timestampEnd);
}
