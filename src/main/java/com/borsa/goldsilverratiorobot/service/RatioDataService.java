package com.borsa.goldsilverratiorobot.service;

import com.borsa.goldsilverratiorobot.entity.RatioData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.borsa.goldsilverratiorobot.repository.RatioDataRepo;

import java.util.List;

@Service

public class RatioDataService {

    private final RatioDataRepo ratioDataRepo;

    @Autowired
    public RatioDataService(RatioDataRepo repo) {
        ratioDataRepo = repo;
    }


    public List<RatioData> getRatioDataBetween(long timestampStart, long timestampEnd){
        return ratioDataRepo.findByTimestampIsBetween(timestampStart, timestampEnd);
    }

    public void saveRatioData(RatioData ratioData) {
        ratioDataRepo.save(ratioData);
    }
}
