
package com.example.sis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // CREATE TABLE
    public void createTable() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS Students (
                    StudentID INTEGER PRIMARY KEY AUTOINCREMENT,
                    RollNumber TEXT NOT NULL UNIQUE,
                    StudentName TEXT NOT NULL,
                    Email TEXT NOT NULL UNIQUE,
                    Department TEXT NOT NULL,
                    Marks REAL NOT NULL CHECK (Marks BETWEEN 0 AND 100)
                )
                """;

        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement()) {
            stmt.execute(sql);
        }
    }

    // INSERT STUDENT
    public boolean insertStudent(Student student) throws SQLException {
        String sql = """
                INSERT INTO Students
                (RollNumber, StudentName, Email, Department, Marks)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getRollNumber());
            ps.setString(2, student.getStudentName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getDepartment());
            ps.setDouble(5, student.getMarks());

            return ps.executeUpdate() > 0;
        }
    }

    // DISPLAY ALL STUDENTS
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Students ORDER BY StudentID";

        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                students.add(mapStudent(rs));
            }
        }

        return students;
    }

    // SEARCH STUDENT BY ROLL NUMBER
    public Student searchStudent(String rollNumber) throws SQLException {
        String sql = "SELECT * FROM Students WHERE RollNumber = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, rollNumber);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapStudent(rs);
                }
            }
        }

        return null;
    }

    // SEARCH STUDENTS USING WHERE
    public List<Student> searchByDepartment(String department)
            throws SQLException {
        List<Student> students = new ArrayList<>();

        String sql = """
                SELECT * FROM Students
                WHERE Department = ?
                ORDER BY StudentName
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, department);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    students.add(mapStudent(rs));
                }
            }
        }

        return students;
    }

    // SEARCH STUDENTS USING BETWEEN
    public List<Student> searchByMarks(double min, double max)
            throws SQLException {
        List<Student> students = new ArrayList<>();

        String sql = """
                SELECT * FROM Students
                WHERE Marks BETWEEN ? AND ?
                ORDER BY Marks DESC
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, min);
            ps.setDouble(2, max);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    students.add(mapStudent(rs));
                }
            }
        }

        return students;
    }

    // SEARCH STUDENTS USING LIKE
    public List<Student> searchByName(String name)
            throws SQLException {
        List<Student> students = new ArrayList<>();

        String sql = """
                SELECT * FROM Students
                WHERE StudentName LIKE ?
                ORDER BY StudentName
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    students.add(mapStudent(rs));
                }
            }
        }

        return students;
    }

    // SEARCH STUDENTS USING IN
    public List<Student> searchByDepartments(List<String> departments)
            throws SQLException {
        List<Student> students = new ArrayList<>();

        if (departments == null || departments.isEmpty()) {
            return students;
        }

        String placeholders = String.join(
                ",", java.util.Collections.nCopies(departments.size(), "?")
        );

        String sql = "SELECT * FROM Students WHERE Department IN ("
                + placeholders + ") ORDER BY StudentName";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            for (int i = 0; i < departments.size(); i++) {
                ps.setString(i + 1, departments.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    students.add(mapStudent(rs));
                }
            }
        }

        return students;
    }

    // UPDATE STUDENT
    public boolean updateStudent(Student student) throws SQLException {
        String sql = """
                UPDATE Students
                SET StudentName = ?,
                    Email = ?,
                    Department = ?,
                    Marks = ?
                WHERE RollNumber = ?
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getDepartment());
            ps.setDouble(4, student.getMarks());
            ps.setString(5, student.getRollNumber());

            return ps.executeUpdate() > 0;
        }
    }

    // DELETE STUDENT
    public boolean deleteStudent(String rollNumber) throws SQLException {
        String sql = "DELETE FROM Students WHERE RollNumber = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, rollNumber);

            return ps.executeUpdate() > 0;
        }
    }

    // HELPER METHOD: Convert database row into Student object
    private Student mapStudent(ResultSet rs) throws SQLException {
        return new Student(
                rs.getInt("StudentID"),
                rs.getString("RollNumber"),
                rs.getString("StudentName"),
                rs.getString("Email"),
                rs.getString("Department"),
                rs.getDouble("Marks")
        );
    }
}
