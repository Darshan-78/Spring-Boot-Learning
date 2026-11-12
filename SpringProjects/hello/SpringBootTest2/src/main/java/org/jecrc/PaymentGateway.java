package org.jecrc;

import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    private final PaymentProperties properties;

    public PaymentGateway(PaymentProperties properties) {
        this.properties = properties;
    }

    public void print() {

        System.out.println("Payment Type: " + properties.getType());

        System.out.println("Retry Count: " + properties.getRetryCount());

        System.out.println("Payment Enabled: " + properties.isEnabled());

        System.out.println("Payment Timeout: " + properties.getTimeout());
    }
}
