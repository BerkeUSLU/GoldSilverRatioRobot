package service;

import entity.RatioData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import repository.RatioDataRepo;

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
