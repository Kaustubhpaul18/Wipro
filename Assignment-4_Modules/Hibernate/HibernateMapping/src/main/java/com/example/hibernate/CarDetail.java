package com.example.hibernate;
import jakarta.persistence.*;
@Entity
@Table(name = "car_detail")
public class CarDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    private String model;
    private String company;
    public CarDetail() {}
    public CarDetail(String model, String company) {
        this.model = model;
        this.company = company;
    }
}