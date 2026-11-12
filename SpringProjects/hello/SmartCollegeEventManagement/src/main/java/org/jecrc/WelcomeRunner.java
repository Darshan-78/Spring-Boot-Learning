package org.jecrc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class WelcomeRunner implements CommandLineRunner {

    private final CollegeProperties college;
    private final EventProperties event;
    private final RegistrationProperties registration;

    public WelcomeRunner(
            CollegeProperties college,
            EventProperties event,
            RegistrationProperties registration) {

        this.college = college;
        this.event = event;
        this.registration = registration;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("\n====================================");
        System.out.println("     WELCOME TO COLLEGE EVENTS");
        System.out.println("====================================");

        System.out.println("College Name: " +
                college.getCollegeName());

        System.out.println("Event Name: " +
                event.getEventName());

        System.out.println("Event Venue: " +
                event.getVenue());

        System.out.println("Registration Status: " +
                (registration.isEnabled() ? "OPEN" : "CLOSED"));

        System.out.println("====================================\n");
    }
}