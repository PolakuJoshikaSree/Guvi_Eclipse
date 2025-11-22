package com.flightapp.request;

import com.flightapp.model.enums.Gender;
import com.flightapp.model.enums.MealType;
import jakarta.validation.constraints.*;

public class PassengerRequest {

    @NotBlank
    private String name;

    @NotNull
    private Gender gender;

    @Min(0)
    private int age;

    private MealType mealPreference;

    @Min(0)
    private double luggageWeight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
