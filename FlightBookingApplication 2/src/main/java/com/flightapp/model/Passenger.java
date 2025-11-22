package com.flightapp.model;

import com.flightapp.model.enums.Gender;
import com.flightapp.model.enums.MealType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String passengerName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Min(0)
    private int age;

    @Enumerated(EnumType.STRING)
    private MealType mealPreference;

    @Min(0)
    private double luggageWeight;

    @ManyToOne
    private Booking booking;

    public Passenger() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MealType getMealPreference() {
        return mealPreference;
    }

    public void setMealPreference(MealType mealPreference) {
        this.mealPreference = mealPreference;
    }

    public double getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(double luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
