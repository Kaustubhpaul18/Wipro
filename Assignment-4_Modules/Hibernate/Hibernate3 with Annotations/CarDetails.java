package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CAR_DETAILS")
public class CarDetails {

    @Id
    @Column(name = "REGNO", length = 5, nullable = false)
    private String regNo;

    @Column(name = "MODEL", length = 20, nullable = false)
    private String model;

    @Column(name = "COLOR", length = 10)
    private String color;

    @Column(name = "MANUFACTURER", length = 20)
    private String manufacturer;

    // Getters and Setters
    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    @Override
    public String toString() {
        return "CarDetails [regNo=" + regNo + ", model=" + model + ", color=" + color + ", manufacturer=" + manufacturer + "]";
    }
}
