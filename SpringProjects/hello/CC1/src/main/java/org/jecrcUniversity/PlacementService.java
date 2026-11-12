package org.jecrcUniversity;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class PlacementService {

    private final StudentService StudentService;

    public PlacementService(StudentService StudentService) {
        this.StudentService = StudentService;
        System.out.println("PlacementService created");
    }

    public void showPlacementDetails() {
        System.out.println("Placement details displayed");
    }
}
