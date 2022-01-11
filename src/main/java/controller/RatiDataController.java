package controller;

import entity.RatioData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import service.RatioDataService;

@Controller
public class RatiDataController {

    private final RatioDataService service;
    @Autowired
    public RatiDataController(RatioDataService se) {
        service = se;
    }


    public void saveCurrentRatio(RatioData data) {
        service.saveRatioData(data);
    }

}
