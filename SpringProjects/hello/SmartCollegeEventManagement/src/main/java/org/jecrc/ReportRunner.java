package org.jecrc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ReportRunner implements ApplicationRunner {

    @Value("${spring.application.name}")
    private String applicationName;

    private final CollegeProperties college;
    private final EventProperties event;
    private final RegistrationProperties registration;

    public ReportRunner(
            CollegeProperties college,
            EventProperties event,
            RegistrationProperties registration) {

        this.college = college;
        this.event = event;
        this.registration = registration;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("\n====================================");
        System.out.println("       APPLICATION STARTUP REPORT");
        System.out.println("====================================");

        System.out.println("Application Name: " +
                applicationName);

        System.out.println("Academic Year: " +
                college.getAcademicYear());

        System.out.println("Total Participant Capacity: " +
                registration.getMaxParticipants());

        System.out.println("Registration Fee: Rs. " +
                registration.getFee());

        System.out.println("Early Bird Discount: " +
                registration.getDiscount() + "%");

        System.out.println("Event Organizer: " +
                event.getOrganizer());

        System.out.println("Registration Last Date: " +
                registration.getLastDate());

        System.out.println("====================================\n");
    }
}