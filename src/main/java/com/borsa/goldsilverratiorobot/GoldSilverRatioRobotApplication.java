package com.borsa.goldsilverratiorobot;

import com.borsa.goldsilverratiorobot.entity.RatioData;
import com.borsa.goldsilverratiorobot.model.RatioDataTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import com.borsa.goldsilverratiorobot.service.RatioDataService;

import java.util.Collections;

@SpringBootApplication

public class GoldSilverRatioRobotApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoldSilverRatioRobotApplication.class, args);
    }





    @Bean
    public CommandLineRunner run(RestTemplate restTemplate, RatioDataService service,  RatioDataTracker tracker) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                service.updateRatio();
                tracker.setDataList(service.getAllData());
                System.out.println(tracker.analyse());

            }
        };
    }

}
