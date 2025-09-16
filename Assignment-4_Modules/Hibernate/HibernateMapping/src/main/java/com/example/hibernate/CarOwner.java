package com.example.hibernate;
import jakarta.persistence.*;
@Entity
@Table(name = "car_owner")
public class CarOwner {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerId;
    private String ownerName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private CarDetail car;
    public CarOwner() {}
    public CarOwner(String ownerName, CarDetail car) {
        this.ownerName = ownerName;
        this.car = car;
    }
}