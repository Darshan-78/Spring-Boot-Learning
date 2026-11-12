package com.jecrc.CRUDSpringDemo.service;

import com.jecrc.CRUDSpringDemo.entity.Student;
import com.jecrc.CRUDSpringDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    //1. Listen to an Endpoint
    //2. Business Logic
    //3. Finally Interact with database
    //4. Response too Client
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        System.out.println("Inside Student Service");
        System.out.println("Exiting Student Service");
        Student studentResp = studentRepository.saveStudent(studentReq);

        return studentReq;
    }

}
