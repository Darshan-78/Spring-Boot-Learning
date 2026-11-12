package com.jecrc.springcoredemo.payment;

public class UpiPayment implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Paid by UPI...");
    }
}