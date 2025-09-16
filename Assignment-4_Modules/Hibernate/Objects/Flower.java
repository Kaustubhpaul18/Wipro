package com.example;

public class Flower {
    private String flowerId;
    private String flowerName;
    private String color;
    private double price;

    // Getters and Setters
    public String getFlowerId() { return flowerId; }
    public void setFlowerId(String flowerId) { this.flowerId = flowerId; }

    public String getFlowerName() { return flowerName; }
    public void setFlowerName(String flowerName) { this.flowerName = flowerName; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "Flower [flowerId=" + flowerId + ", flowerName=" + flowerName +
               ", color=" + color + ", price=" + price + "]";
    }
}