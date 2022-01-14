package com.borsa.goldsilverratiorobot.controller;

import com.borsa.goldsilverratiorobot.entity.RatioData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.borsa.goldsilverratiorobot.service.RatioDataService;

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
