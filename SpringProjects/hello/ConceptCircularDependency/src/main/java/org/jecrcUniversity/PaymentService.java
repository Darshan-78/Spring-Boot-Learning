package org.jecrcUniversity;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    private final OrderService orderService;

    public PaymentService(OrderService orderService) {
        this.orderService = orderService;
        System.out.println("PaymentService created");
    }

    public void pay() {
        System.out.println("Payment done successfully.");
    }
}
