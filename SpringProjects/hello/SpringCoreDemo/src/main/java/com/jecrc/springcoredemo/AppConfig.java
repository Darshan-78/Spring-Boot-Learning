package com.jecrc.springcoredemo;

import com.jecrc.springcoredemo.payment.CardPayment;
import com.jecrc.springcoredemo.payment.PaymentService;
import com.jecrc.springcoredemo.payment.UpiPayment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public User createUser() {
        return new User("Gaurav", 22);
    }

    @Bean
    public CartService createCartService() {
        return new CartService();
    }

    @Bean
    public PaymentService cardPayment() {
        return new CardPayment();
    }

    @Bean
    public PaymentService upiPayment() {
        return new UpiPayment();
    }

    @Bean
    public OrderService createOrderService(
            @Qualifier("cardPayment") PaymentService service) {
        return new OrderService(service);
    }
}