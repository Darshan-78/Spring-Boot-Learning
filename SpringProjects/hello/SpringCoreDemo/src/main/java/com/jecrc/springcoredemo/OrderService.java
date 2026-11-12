package org.jecrc;

import org.jecrc.payment.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class OrderService {
    //field injection method
//@Autowired
    private PaymentService service;
    @Autowired
    public OrderService(PaymentService service) {
        this.service = service;
    }
    //Constructor injection
    // @Autowired
    // public OrderService(paymentService service)
    //  {
    //  this.service = service;
    //}
//setter injection method
    @Autowired
    public void setService(PaymentService service) {
        this.service = service;
    }
    public void placeOrder()
    {
        service.pay();
        System.out.println("Order Placed");
    }
}