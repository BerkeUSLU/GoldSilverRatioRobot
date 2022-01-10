package service;

import entities.RatioData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RatioDataRepo;

import java.util.List;

@Service
public class RatioDataService {
    @Autowired
    RatioDataRepo ratioDataRepo;


    public List<RatioData> getRatioDataBetween(long timestampStart, long timestampEnd){
        return ratioDataRepo.findByTimestampIsBetween(timestampStart, timestampEnd);
    }

    public void saveRatioData(RatioData ratioData) {
        ratioDataRepo.save(ratioData);
    }
}
