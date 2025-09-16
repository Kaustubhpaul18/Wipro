package com.wipro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String gender;
    private String designation;
    private double salary;
    private String city;
    private String email;
    private String mobile;

    // Getters and Setters
}
