package com.jecrc;

public class PaymentService {

    private String type;
    private int retryCount;

    public PaymentService(String type, int retryCount) {
        this.type = type;
        this.retryCount = retryCount;
    }

    public void pay() {
        System.out.println("Payment done");
        System.out.println("Payment Type: " + type);
        System.out.println("Retry Count: " + retryCount);
    }
}