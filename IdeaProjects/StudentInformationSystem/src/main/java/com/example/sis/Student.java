
package com.example.sis;

public class Student {

    private int studentID;
    private String rollNumber;
    private String studentName;
    private String email;
    private String department;
    private double marks;

    public Student(int studentID, String rollNumber,
                   String studentName, String email,
                   String department, double marks) {
        this.studentID = studentID;
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.email = email;
        this.department = department;
        this.marks = marks;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    public double getMarks() {
        return marks;
    }
}
