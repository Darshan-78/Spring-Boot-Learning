package com.campus.event;

import org.springframework.stereotype.Component;

@Component
public class SMSNotification implements NotificationService {

    @Override
    public void sendNotification(String message) {
        System.out.println("SMS Notification: " + message);
    }
}