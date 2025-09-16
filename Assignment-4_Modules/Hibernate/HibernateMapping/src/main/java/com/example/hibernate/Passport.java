package com.example.hibernate;
import jakarta.persistence.*;
@Entity
@Table(name = "passport")
public class Passport {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passportId;
    private String passportNumber;
    public Passport() {}
    public Passport(String passportNumber) { this.passportNumber = passportNumber; }
}