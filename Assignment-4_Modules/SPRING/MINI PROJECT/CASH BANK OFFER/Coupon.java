package com.example.cashback.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Coupon {
    @Id
    private String couponCode;
    private int offerPercentage;

    // Getters & Setters
    public String getCouponCode() { return couponCode; }
    public void setCouponCode(String couponCode) { this.couponCode = couponCode; }

    public int getOfferPercentage() { return offerPercentage; }
    public void setOfferPercentage(int offerPercentage) { this.offerPercentage = offerPercentage; }
}
