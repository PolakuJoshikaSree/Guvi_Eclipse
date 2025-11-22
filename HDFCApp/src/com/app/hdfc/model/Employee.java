package com.app.hdfc.model;

public class Employee {
    private String name;
    private String company;
    private double amountPaid;

    public Employee(String name, String company, double amountPaid) {
        this.name = name;
        this.company = company;
        this.amountPaid = amountPaid;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', company='" + company + "', amountPaid=" + amountPaid + "}";
    }
}
