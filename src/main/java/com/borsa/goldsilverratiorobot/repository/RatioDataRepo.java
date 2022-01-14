package com.borsa.goldsilverratiorobot.repository;

import com.borsa.goldsilverratiorobot.entity.RatioData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatioDataRepo extends JpaRepository<RatioData, Long> {
    List<RatioData> findByTimestampIsBetween(long timestampStart, long timestampEnd);
}
