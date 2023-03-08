package com.example.demo.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;


public class ConsumingRestApplication {

    private static final Logger log =
            LoggerFactory.getLogger(ConsumingRestApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote =
                    restTemplate.getForObject(
                            "http://localhost:8080/api/random", Quote.class
                    );
                    log.info(quote.toString());
        }
    }
 }
