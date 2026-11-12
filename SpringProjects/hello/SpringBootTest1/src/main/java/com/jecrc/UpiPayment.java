package com.jecrc;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;

@Component
@Primary
public class UpiPaymentService implements PaymentService {

    private String upiId;

    public UpiPaymentService() {
        this.upiId = "darshan@upi";
        System.out.println("UPI Constructor Called");
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment Mode: UPI");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Amount: Rs. " + amount);
        System.out.println("UPI Payment Successful!");
    }
}