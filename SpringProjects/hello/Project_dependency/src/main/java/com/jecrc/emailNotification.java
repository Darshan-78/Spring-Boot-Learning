package com.jecrc;

import org.springframework.stereotype.Component;

@Component("emailNotification")
public class emailNotification implements Notification {

    @Override
    public void sendNotification() {
        System.out.println("Email notification sent!");
    }
}