package com.jecrc;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public void processPayment() {
        System.out.println("Payment received successfully!");
    }
}