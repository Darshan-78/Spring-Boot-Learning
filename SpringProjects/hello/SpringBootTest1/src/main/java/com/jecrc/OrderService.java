package com.jecrc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService defaultPayment;
    private PaymentService cardPayment;

    @Autowired
    public OrderService(
            PaymentService defaultPayment,
            @Qualifier("cardPayment") PaymentService cardPayment) {

        this.defaultPayment = defaultPayment;
        this.cardPayment = cardPayment;

        System.out.println("OrderService Constructor Called");
    }

    public void payUsingDefault(double amount) {

        System.out.println("\n--- DEFAULT PAYMENT ---");
        defaultPayment.pay(amount);
    }

    public void payUsingCard(double amount) {

        System.out.println("\n--- CARD PAYMENT ---");
        cardPayment.pay(amount);
    }
}