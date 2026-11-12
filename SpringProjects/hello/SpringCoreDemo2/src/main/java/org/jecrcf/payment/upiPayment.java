package org.jecrcf.payment;

import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier
public class upiPayment implements paymentService {
    @Override
    public void pay() {
        System.out.println("paid by upi...");
    }
}