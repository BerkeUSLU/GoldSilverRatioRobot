package com.borsa.goldsilverratiorobot;

import com.borsa.goldsilverratiorobot.entity.RatioData;
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
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }




    @Bean
    public CommandLineRunner run(RestTemplate restTemplate, RatioDataService service) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                HttpHeaders header = new HttpHeaders();
                header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
                header.set("x-access-token", "goldapi-13rntky45h0b9-io");


                HttpEntity<String> entity = new HttpEntity<>("body", header);
                //RatioData data = restTemplate.getForObject("https://www.goldapi.io/api/XAU/XAG/", RatioData.class, com.borsa.goldsilverratiorobot.entity);

                ResponseEntity<RatioData> data = restTemplate.exchange("https://www.goldapi.io/api/XAU/XAG/", HttpMethod.GET, entity, RatioData.class);

                System.out.println(data);



                //service.saveRatioData(data.getBody());

            }
        };
    }

}
