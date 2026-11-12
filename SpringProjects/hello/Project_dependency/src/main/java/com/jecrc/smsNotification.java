package com.jecrc;

import org.springframework.stereotype.Component;

@Component("smsNotification")
public class smsNotification implements Notification {

    @Override
    public void sendNotification() {
        System.out.println("SMS notification sent!");
    }
}
