package com.jecrc;

public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("order service object created...");
    }

    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order Placed");
    }
}