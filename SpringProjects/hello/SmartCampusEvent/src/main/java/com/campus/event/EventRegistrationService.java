package com.campus.event;

import org.springframework.stereotype.Service;

@Service
public class EventRegistrationService {

    private final NotificationService notificationService;

    public EventRegistrationService(EmailNotification notificationService) {
        this.notificationService = notificationService;
    }

    public void registerStudent(String studentName, String eventName) {
        System.out.println(studentName + " registered for " + eventName);

        notificationService.sendNotification(
                "Hello " + studentName
                        + ", your registration for "
                        + eventName + " is confirmed."
        );
    }
}
