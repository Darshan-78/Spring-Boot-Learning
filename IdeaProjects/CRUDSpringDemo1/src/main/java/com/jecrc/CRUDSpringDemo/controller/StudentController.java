package com.jecrc.CRUDSpringDemo.controller;

import com.jecrc.CRUDSpringDemo.entity.Student;
import com.jecrc.CRUDSpringDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*1.*/
//@RestController
/*2.*/
@RestController
@RequestMapping("/api/students")
public class StudentController {

    /*6. create private Data Member */
    private StudentService studentService;

    /*7. NOw Constructor Injection */
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Create Student
    /*3.*/
    @PostMapping("/create")
    /*4. @RequestBody Student student */
//    public void createStudent(@RequestBody Student student)

    /*9. Change the return type */

//    public String createStudent(@RequestBody Student student) // Last Added 3
//    public Student createStudent(@RequestBody Student student) // Last Added 6

    public ResponseEntity<Student> createStudent(@RequestBody Student student) // Last Added 7
    {
        /*5. Hide Both the Lines */
//        System.out.println(student.getName());
//        System.out.println(student.getEmail());

        System.out.println("Inside Student Controller"); // Last Added 1
        System.out.println("Exit from Student Controller"); // Last Added 2

        /*8. Pass the Create Method */
        Student createdStudent = studentService.createStudent(student);
//       return "Student Created"; // Last Added 4
        //return createdStudent; // Last Added 5
        //return ResponseEntity.ok(createdStudent);// Last Added 8 and hide last line
        //return ResponseEntity.status(201).body(createdStudent); // Last Added 9 and hide last line

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent); // Last Added 10 and hide last line
    }

    //Read Student

    //    @GetMapping("get/1") //Initiate Read All
    @GetMapping("get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id)
    {
        Student studentResp = studentService.getStudent(id);
        if(studentResp == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(studentResp);
    }

    //Read All
    @GetMapping("/get")
    public ResponseEntity<List<Student>> getAllStudent()
    {
        List<Student> studentList = studentService.getAllStudent();
        if(studentList.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(studentList);
    }

    //Update Student
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable long id,
            @RequestBody Student student)
    {
        Student studentResp = studentService.updateStudent(id, student);

        if(studentResp == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(studentResp);
    }

    //Delete Student
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id)
    {
        Boolean isDelete = studentService.deleteStudent(id);

        if(!isDelete) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Student Deleted Successfully");
    }
}
