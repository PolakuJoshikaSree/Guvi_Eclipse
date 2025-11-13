package com.smartship.core;

import com.smartship.exceptions.InvalidPackageException;

public class DeliveryPackage implements Comparable<DeliveryPackage> {
    private String packageId;
    private String destinationCity;
    private int priority; 
    private double weight;

    public DeliveryPackage(String packageId, String destinationCity, int priority, double weight) throws InvalidPackageException {
        if (packageId == null || packageId.isEmpty() || weight <= 0)
            throw new InvalidPackageException("Invalid package data.");
        this.packageId = packageId;
        this.destinationCity = destinationCity;
        this.priority = priority;
        this.weight = weight;
    }

    public String getPackageId() { return packageId; }
    public String getDestinationCity() { return destinationCity; }
    public int getPriority() { return priority; }
    public double getWeight() { return weight; }

    @Override
    public int compareTo(DeliveryPackage other) {
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return "Package ID: " + packageId + ", City: " + destinationCity + ", Priority: " + priority + ", Weight: " + weight;
    }
}
