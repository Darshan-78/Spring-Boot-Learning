package com.jecrc.Payment;

import org.springframework.stereotype.Component;

@Component("cardPayment")
public class Card_payment implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Payment received through Card!");
    }
}
