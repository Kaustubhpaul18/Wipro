package com.example.model;

public class Test {
    private String testId;
    private String testTitle;
    private int testMarks;

    // Constructor
    public Test(String testId, String testTitle, int testMarks) {
        this.testId = testId;
        this.testTitle = testTitle;
        this.testMarks = testMarks;
    }

    // Display method
    public void displayTest() {
        System.out.println("Test ID: " + testId);
        System.out.println("Test Title: " + testTitle);
        System.out.println("Test Marks: " + testMarks);
    }
}
