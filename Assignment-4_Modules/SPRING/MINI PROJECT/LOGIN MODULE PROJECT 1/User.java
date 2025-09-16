package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Username is mandatory")
    private String username;

    @Size(min=6, max=6, message="Password must be exactly 6 characters")
    private String password;

    @Pattern(regexp="^[A-Za-z]\\d{4}$", message="Employee ID must be 1 letter + 4 digits")
    private String employeeNumber;

    @Email(message="Invalid email format")
    @NotBlank(message="Email is mandatory")
    private String email;

    // getters and setters
}
