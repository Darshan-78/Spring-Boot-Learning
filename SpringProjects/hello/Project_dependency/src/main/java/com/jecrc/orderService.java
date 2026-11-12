package com.jecrc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class orderService {

    private final Notification notification;
    private final PaymentService paymentService;

    public orderService(
            @Qualifier("emailNotification") Notification notification,
            PaymentService paymentService) {
        this.notification = notification;
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.processPayment();
        System.out.println("Order placed successfully!");
        notification.sendNotification();
    }
}