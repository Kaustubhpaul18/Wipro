package com.example.di.controller;

import com.example.di.model.Laptop;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LaptopController {

    private final Laptop laptop;

    public LaptopController(Laptop laptop) {
        this.laptop = laptop;
    }

    @GetMapping("/laptop")
    public String getLaptopInfo() {
        return laptop.getLaptopDetails();
    }
}
