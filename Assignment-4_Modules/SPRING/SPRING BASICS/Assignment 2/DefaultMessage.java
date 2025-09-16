package com.example.model;

public class DefaultMessage {
    private String message = "Spring";  // default value

    public String getMessage() {
        return message;
    }

    public void displayMessage() {
        System.out.println("Default Message: " + message);
    }
}
