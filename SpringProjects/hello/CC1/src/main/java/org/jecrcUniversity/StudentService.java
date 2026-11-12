package org.jecrcUniversity;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class StudentService {

    private final PlacementService placementService;

    public StudentService(@Lazy PlacementService placementService) {
        this.placementService = placementService;
        System.out.println("StudentService created");
    }

    public void showStudentDetails() {
        System.out.println("Student details displayed");
        placementService.showPlacementDetails();
    }
}
