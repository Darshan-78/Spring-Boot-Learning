package org.jecrcf;

import org.jecrcf.payment.paymentService;

public class OrderService2 {

    private paymentService service;

    // No-argument constructor
    public OrderService2() {
    }

    // Parameterized constructor
    public OrderService2(paymentService service) {
        this.service = service;
    }

    // Setter injection
    public void setService(paymentService service) {
        this.service = service;
    }

    public void placeOrder() {
        service.pay();
        System.out.println("Order Placed");
    }
}
