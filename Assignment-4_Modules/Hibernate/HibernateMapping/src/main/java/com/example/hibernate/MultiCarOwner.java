package com.example.hibernate;
import jakarta.persistence.*;
import java.util.*;
@Entity
@Table(name = "multi_car_owner")
public class MultiCarOwner {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ownerId;
    private String ownerName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private List<CarDetail> cars = new ArrayList<>();
    public MultiCarOwner() {}
    public MultiCarOwner(String ownerName) { this.ownerName = ownerName; }
    public void addCar(CarDetail car) { cars.add(car); }
}