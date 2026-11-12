package org.jecrc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@RestController
public class HelloWorld {

    // GET API 1
    @GetMapping("/")
    public String print() {
        return "hello from ju";
    }

    // GET API 2
    @GetMapping("/student")
    public Map<String, Object> getStudent() {
        return Map.of(
                "studentId", 101,
                "studentName", "Rahul",
                "department", "AI & DS",
                "college", "JECRC University",
                "year", 2026,
                "status", "Active"
        );
    }

    // POST API
    @PostMapping("/student")
    public Map<String, Object> addStudent(
            @RequestBody Map<String, Object> student) {
        return student;
    }
}
