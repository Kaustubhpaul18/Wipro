package com.example.di.model;

import org.springframework.stereotype.Component;

@Component
public class Battery {
    public String getDetails() {
        return "5000mAh Battery";
    }
}
