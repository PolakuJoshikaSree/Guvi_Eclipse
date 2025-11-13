package com.smartship.core;

import com.smartship.exceptions.RouteUnavailableException;

public class Route {
    private String fromCity;
    private String toCity;
    private double distance;

    public Route(String fromCity, String toCity, double distance) {
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distance = distance;
    }

    public String getFromCity() { return fromCity; }
    public String getToCity() { return toCity; }
    public double getDistance() { return distance; }

    public void validate() throws RouteUnavailableException {
        if (distance <= 0)
            throw new RouteUnavailableException("Route from " + fromCity + " to " + toCity + " is invalid.");
    }
}
