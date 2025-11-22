package com.smartpay.model;

public class Beneficiary {

    private String name;

    // Constructor that takes name
    public Beneficiary(String name) {
        this.name = name;
    }

    // Getter
    public String getName() {
        return name;
    }

    // Optional: Setter
    public void setName(String name) {
        this.name = name;
    }
}
