package com.wipro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String userid;
    private String password;

    // Getters & Setters
}
