package com.bigboytoys;

// Vehicle is an abstract class because not every vehicle can be directly created.
// This acts as a blueprint for any type of vehicle like car, bike, etc.
// It represents Abstraction (common idea of a Vehicle).and acts as parent class in case of inheritance.
public abstract class Vehicle {
    
    // Keeping these fields private to follow Encapsulation.so can use getters and setters.
	// Basically to make sure the unnecessary internal details to be hidden.
    private String brand;
    private String model;
    private double exShowroomPrice;

    // Constructor initializes basic details .
    public Vehicle(String brand, String model, double exShowroomPrice) {
        this.brand = brand;
        this.model = model;
        this.exShowroomPrice = exShowroomPrice;
    }

    // Getters allow controlled access to private data.
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getExShowroomPrice() { return exShowroomPrice; }

    // This Abstract method ensures every specific Vehicle gets its own pricing.
    public abstract double calculateOnRoadPrice();
}
