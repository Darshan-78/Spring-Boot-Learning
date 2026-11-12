package com.jecrc.Payment;

import org.springframework.stereotype.Component;

@Component("upiPayment")
public class upi_payment implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Payment received through UPI!");
    }
}
