package com.jecrc.CRUDSpringDemo.repository;

import com.jecrc.CRUDSpringDemo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {

    public Student saveStudent(Student student) {
        System.out.println("Inside Student Repository");
        System.out.println("Exiting Student Repository");
//            System.out.println("Student ID: " + student.getId());
//            System.out.println("Student Name: " + student.getName());
//            System.out.println("Student Email: " + student.getEmail());
//            System.out.println("Student Age: " + student.getAge());
//            System.out.println("Student Roll No: " + student.getRollNo());
//            System.out.println("Student Subject: " + student.getSubject());

//            return null;

        Student s1 = new Student();
        s1.setName("John Doe");
        s1.setEmail("john.doe@example.com");
        s1.setAge(20);
        s1.setRollNo(12345);
        s1.setSubject("Mathematics");
        return s1;
    }
}