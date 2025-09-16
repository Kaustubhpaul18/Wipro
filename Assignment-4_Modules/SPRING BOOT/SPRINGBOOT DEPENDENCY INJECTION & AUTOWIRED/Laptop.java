package com.example.di.model;

import org.springframework.stereotype.Component;

@Component
public class Laptop {
    private final HardDisk hardDisk;
    private final Battery battery;

    public Laptop(HardDisk hardDisk, Battery battery) {
        this.hardDisk = hardDisk;
        this.battery = battery;
    }

    public String getLaptopDetails() {
        return "Laptop with " + hardDisk.getDetails() + " and " + battery.getDetails();
    }
}
