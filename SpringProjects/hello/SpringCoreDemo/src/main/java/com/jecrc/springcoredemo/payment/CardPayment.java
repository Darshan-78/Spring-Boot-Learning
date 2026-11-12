package com.jecrc.springcoredemo.payment;

public class CardPayment implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Paid by Card...");
    }
}