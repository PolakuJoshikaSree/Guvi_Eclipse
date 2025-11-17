package com.flightapp.model;

import com.flightapp.model.enums.MealType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String flightNumber;

    @ManyToOne
    private Airline airline;

    @NotBlank
    private String fromPlace;

    @NotBlank
    private String toPlace;

    @NotNull
    private LocalDate flightDate;

    private LocalTime departureTime;
    private LocalTime arrivalTime;

    @Min(1)
    private int totalSeats;

    @Min(0)
    private int bookedSeats;

    @Min(0)
    private double price;

    @Enumerated(EnumType.STRING)
    private MealType mealTypeAvailable;

    @Min(0)
    private double baggageLimitKg;

    public Flight() {}

    public int getAvailableSeats() {
        return totalSeats - bookedSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public LocalDate getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDate flightDate) {
        this.flightDate = flightDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public MealType getMealTypeAvailable() {
        return mealTypeAvailable;
    }

    public void setMealTypeAvailable(MealType mealTypeAvailable) {
        this.mealTypeAvailable = mealTypeAvailable;
    }

    public double getBaggageLimitKg() {
        return baggageLimitKg;
    }

    public void setBaggageLimitKg(double baggageLimitKg) {
        this.baggageLimitKg = baggageLimitKg;
    }
}
