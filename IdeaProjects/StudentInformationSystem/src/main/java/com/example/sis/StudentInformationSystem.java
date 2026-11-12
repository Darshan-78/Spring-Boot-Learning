
package com.example.sis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentInformationSystem {

    private static final Scanner sc = new Scanner(System.in);
    private static final StudentDAO dao = new StudentDAO();

    public static void main(String[] args) {
        try {
            dao.createTable();
            System.out.println("Student Information System Started!");

            while (true) {
                System.out.println("\n===== STUDENT INFORMATION SYSTEM =====");
                System.out.println("1. Insert Student");
                System.out.println("2. Display All Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = readInt();

                try {
                    switch (choice) {
                        case 1 -> insertStudent();
                        case 2 -> displayStudents(dao.getAllStudents());
                        case 3 -> searchMenu();
                        case 4 -> updateStudent();
                        case 5 -> deleteStudent();
                        case 6 -> {
                            System.out.println("Exiting program. Goodbye!");
                            sc.close();
                            return;
                        }
                        default -> System.out.println("Invalid choice. Try again.");
                    }
                } catch (SQLException e) {
                    System.out.println("Database error: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println("Could not initialize database: " + e.getMessage());
        }
    }

    private static void insertStudent() throws SQLException {
        System.out.println("\n--- Insert Student ---");

        System.out.print("Roll Number: ");
        String roll = readText();

        System.out.print("Student Name: ");
        String name = readText();

        System.out.print("Email: ");
        String email = readText();

        System.out.print("Department: ");
        String department = readText();

        System.out.print("Marks (0-100): ");
        double marks = readMarks();

        Student student = new Student(
                0, roll, name, email, department, marks
        );

        if (dao.insertStudent(student)) {
            System.out.println("Student inserted successfully!");
        } else {
            System.out.println("Student could not be inserted.");
        }
    }

    private static void displayStudents(List<Student> students) {
        System.out.println("\n--- Student Records ---");

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.printf(
                "%-5s %-12s %-22s %-28s %-15s %-8s%n",
                "ID", "Roll No.", "Name", "Email", "Department", "Marks"
        );
        System.out.println("-".repeat(100));

        for (Student s : students) {
            System.out.printf(
                    "%-5d %-12s %-22s %-28s %-15s %-8.2f%n",
                    s.getStudentID(),
                    s.getRollNumber(),
                    s.getStudentName(),
                    s.getEmail(),
                    s.getDepartment(),
                    s.getMarks()
            );
        }
    }

    private static void searchMenu() throws SQLException {
        while (true) {
            System.out.println("\n--- Search Students ---");
            System.out.println("1. Search by Roll Number (WHERE)");
            System.out.println("2. Search by Department (WHERE)");
            System.out.println("3. Search by Multiple Departments (IN)");
            System.out.println("4. Search by Marks Range (BETWEEN)");
            System.out.println("5. Search by Name (LIKE)");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter roll number: ");
                    Student student = dao.searchStudent(readText());

                    if (student == null) {
                        System.out.println("Student not found.");
                    } else {
                        displayStudents(List.of(student));
                    }
                }
                case 2 -> {
                    System.out.print("Enter department: ");
                    displayStudents(
                            dao.searchByDepartment(readText())
                    );
                }
                case 3 -> {
                    System.out.print(
                            "Enter departments separated by commas: "
                    );
                    String[] values = readText().split(",");
                    List<String> departments = new ArrayList<>();

                    for (String value : values) {
                        if (!value.trim().isEmpty()) {
                            departments.add(value.trim());
                        }
                    }

                    displayStudents(
                            dao.searchByDepartments(departments)
                    );
                }
                case 4 -> {
                    System.out.print("Minimum marks: ");
                    double min = readMarks();

                    System.out.print("Maximum marks: ");
                    double max = readMarks();

                    if (min > max) {
                        System.out.println(
                                "Minimum marks cannot exceed maximum marks."
                        );
                    } else {
                        displayStudents(
                                dao.searchByMarks(min, max)
                        );
                    }
                }
                case 5 -> {
                    System.out.print("Enter name or part of name: ");
                    displayStudents(
                            dao.searchByName(readText())
                    );
                }
                case 6 -> {
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void updateStudent() throws SQLException {
        System.out.println("\n--- Update Student ---");
        System.out.print("Enter roll number of student to update: ");
        String roll = readText();

        Student existing = dao.searchStudent(roll);

        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Enter the updated details:");

        System.out.print("New name: ");
        String name = readText();

        System.out.print("New email: ");
        String email = readText();

        System.out.print("New department: ");
        String department = readText();

        System.out.print("New marks (0-100): ");
        double marks = readMarks();

        Student updated = new Student(
                existing.getStudentID(),
                roll,
                name,
                email,
                department,
                marks
        );

        if (dao.updateStudent(updated)) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Update failed.");
        }
    }

    private static void deleteStudent() throws SQLException {
        System.out.println("\n--- Delete Student ---");
        System.out.print("Enter roll number to delete: ");
        String roll = readText();

        Student existing = dao.searchStudent(roll);

        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print(
                "Delete " + existing.getStudentName()
                        + "? Type YES to confirm: "
        );
        String confirmation = readText();

        if (confirmation.equalsIgnoreCase("YES")) {
            if (dao.deleteStudent(roll)) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Delete failed.");
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    private static String readText() {
        while (true) {
            String value = sc.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.print("Input cannot be empty. Try again: ");
        }
    }

    private static int readInt() {
        while (true) {
            String value = sc.nextLine().trim();

            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid whole number: ");
            }
        }
    }

    private static double readMarks() {
        while (true) {
            String value = sc.nextLine().trim();

            try {
                double marks = Double.parseDouble(value);

                if (Double.isFinite(marks)
                        && marks >= 0 && marks <= 100) {
                    return marks;
                }
            } catch (NumberFormatException ignored) {
                // Show the validation message below.
            }

            System.out.print("Enter marks between 0 and 100: ");
        }
    }
}
