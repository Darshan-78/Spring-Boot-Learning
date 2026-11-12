package com.jecrc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jecrc")
public class AppConfig {
//    @Bean
//    public String createBean() {
//        return "Hello from Bean";
//    }
//
//    @Bean
//    public Integer numberBean() {
//        return 10;
//    }
//
//    public void demo() {
//        System.out.println("Return from demo");
//    }

    @Bean
    public CartService getCartService() {
        return new CartService();
    }
}