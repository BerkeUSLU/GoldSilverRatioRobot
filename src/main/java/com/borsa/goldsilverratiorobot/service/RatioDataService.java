package com.borsa.goldsilverratiorobot.service;

import com.borsa.goldsilverratiorobot.entity.RatioData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import com.borsa.goldsilverratiorobot.repository.RatioDataRepo;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.*;
import java.util.Collections;
import java.util.List;

@Service

public class RatioDataService {

    private final RatioDataRepo ratioDataRepo;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

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

    public List<RatioData> getAllData() {
        return ratioDataRepo.findAll(Sort.by(Sort.Direction.DESC, "timestamp"));
        //return ratioDataRepo.findAll();
    }

    public void updateRatio() {
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        header.set("x-access-token", "goldapi-13rntky45h0b9-io");


        HttpEntity<String> entity = new HttpEntity<>("body", header);
        //RatioData data = restTemplate.getForObject("https://www.goldapi.io/api/XAU/XAG/", RatioData.class, com.borsa.goldsilverratiorobot.entity);
        String year = "2022";
        String month = "01";
        int day = 1;
        //TODO: get last updated day
        //update db till today
       /* for (int i = 1; i < 14; i++) {
            ResponseEntity<RatioData> data = restTemplate.exchange("https://www.goldapi.io/api/XAU/XAG/"+year+month+i  ,
                    HttpMethod.GET, entity, RatioData.class);

            saveRatioData(data.getBody());
        }*/
    }
}
