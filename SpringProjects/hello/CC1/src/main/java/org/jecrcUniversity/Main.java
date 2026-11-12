package org.jecrcUniversity;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        System.out.println("Starting Spring container...");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("Spring container started.");

        StudentService studentService =
                context.getBean(StudentService.class);

        studentService.showStudentDetails();

        context.close();
    }
}
