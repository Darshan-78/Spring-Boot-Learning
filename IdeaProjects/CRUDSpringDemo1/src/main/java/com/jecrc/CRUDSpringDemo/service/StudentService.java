
package com.jecrc.CRUDSpringDemo.service;

import com.jecrc.CRUDSpringDemo.entity.Student;
import com.jecrc.CRUDSpringDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*5*/
@Service
/*4*/
//@Component
public class StudentService {

    //1. Listen an Endpoint(/app/student POST)
    //2. Business Logic
    //3. Finally Interact with Database
    //4. Response back to Client

    /*2*/
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    /*1*/
    public Student createStudent(Student studentReq){
        //Business Logic
        //Store to DB -But its not the work of service
//        System.out.println("Inside Student Service"); // Last Added 1
//        System.out.println("Exit from Student Service"); // Last Added 2

        /*3*/
        Student studentResp = studentRepository.save(studentReq);
        return studentResp; //Pass to Controller
    }

    //Read Student
    public Student getStudent(long id)
    {
        //return studentRepository.getOne(id);
        Optional<Student> studentResp = studentRepository.findById(id);

        if(studentResp.isPresent())
        {
            return studentResp.get();
        }
        return null;
    }

    //Read All
    public List<Student> getAllStudent()
    {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(studentList::add);
        return studentList;
    }

    //Update Student
    public Student updateStudent(long id, Student studentReq)
    {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(studentOptional.isPresent())
        {
            Student studentToSave = studentOptional.get();

            studentToSave.setName(studentReq.getName());
            studentToSave.setEmail(studentReq.getEmail());
            studentToSave.setAge(studentReq.getAge());
            studentToSave.setRollNo(studentReq.getRollNo());
            studentToSave.setSubject(studentReq.getSubject());

            return studentRepository.save(studentToSave);
        }

        return null;
    }

    //Delete Student
    public Boolean deleteStudent(long id)
    {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(studentOptional.isPresent())
        {
            studentRepository.deleteById(id);
            return true;
        }

        return false;
    }
}