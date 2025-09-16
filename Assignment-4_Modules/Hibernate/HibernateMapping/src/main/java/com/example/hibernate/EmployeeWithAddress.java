package com.example.hibernate;
import jakarta.persistence.*;
@Entity
@Table(name = "employee_address")
public class EmployeeWithAddress {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    @Embedded
    private Address address;
    public EmployeeWithAddress() {}
    public EmployeeWithAddress(String empName, Address address) {
        this.empName = empName; this.address = address;
    }
}