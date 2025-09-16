package com.example.hibernate;
import jakarta.persistence.*;
@Entity
@Table(name = "employee")
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "passport_id")
    private Passport passport;
    public Employee() {}
    public Employee(String empName, Passport passport) {
        this.empName = empName;
        this.passport = passport;
    }
}