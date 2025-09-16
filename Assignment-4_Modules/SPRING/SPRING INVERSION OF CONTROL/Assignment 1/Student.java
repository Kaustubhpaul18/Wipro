package com.example.model;

public class Student {
    private String studentId;
    private String studentName;
    private Test studentTest;

    // Constructor
    public Student(String studentId, String studentName, Test studentTest) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentTest = studentTest;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Test getStudentTest() {
        return studentTest;
    }

    // Display details
    public void displayDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Test Details: ");
        studentTest.displayTest();
        System.out.println("--------------------------");
    }
}
