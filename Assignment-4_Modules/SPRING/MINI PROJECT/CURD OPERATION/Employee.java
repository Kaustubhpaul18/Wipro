package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private String designation;
    private Double salary;
    private String city;
    private String emailId;
    private String mobileNo;

    // getters and setters
}
