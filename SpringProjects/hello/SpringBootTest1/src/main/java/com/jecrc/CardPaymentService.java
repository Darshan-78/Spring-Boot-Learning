package com.jecrc;

import org.springframework.stereotype.Component;

@Component("cardPayment")
public class CardPaymentService implements PaymentService {

    private String cardHolder;

    public CardPaymentService() {
        this.cardHolder = "Darshan";
        System.out.println("Card Constructor Called");
    }

    @Override
    public void pay(double amount) {

        System.out.println("Payment Mode: CARD");
        System.out.println("Card Holder: " + cardHolder);
        System.out.println("Amount: Rs. " + amount);
        System.out.println("Card Payment Successful!");
    }
}