package com.campus.event;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SmartCampusEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                SmartCampusEventApplication.class, args);
    }

    @Bean
    CommandLineRunner run(EventRegistrationService service) {
        return args -> {
            service.registerStudent(
                    "Darshan",
                    "Smart Campus Hackathon"
            );
        };
    }
}