package com.jecrc.CRUDSpringDemo.controller;

import com.jecrc.CRUDSpringDemo.entity.Student;
import com.jecrc.CRUDSpringDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/create")
//    public String createStudent(@RequestBody Student student) {
    //public Student createStudent(@RequestBody Student student) {
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
//        System.out.println("Student ID: " + student.getId());
//        System.out.println("Student Name: " + student.getName());
//        System.out.println("Student Email: " + student.getEmail());
//        System.out.println("Student Age: " + student.getAge());
//        System.out.println("Student Roll No: " + student.getRollNo());
//        System.out.println("Student Subject: " + student.getSubject());

        System.out.println("Inside Student Controller");
        System.out.println("Exiting Student Controller");
        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity.status(201).body(createdStudent);
    }
}
