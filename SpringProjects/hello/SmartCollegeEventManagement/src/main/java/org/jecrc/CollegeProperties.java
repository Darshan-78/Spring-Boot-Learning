package org.jecrc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CollegeProperties {

    @Value("${college.name}")
    private String collegeName;

    @Value("${college.location}")
    private String location;

    @Value("${college.department}")
    private String department;

    @Value("${college.academic-year}")
    private String academicYear;

    @Value("${college.coordinator}")
    private String coordinator;

    public String getCollegeName() {
        return collegeName;
    }

    public String getLocation() {
        return location;
    }

    public String getDepartment() {
        return department;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getCoordinator() {
        return coordinator;
    }
}