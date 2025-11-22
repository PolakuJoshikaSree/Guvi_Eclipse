package com.flightapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("passengers")
public class Passenger {

    @Id
    private Long id;

    private String passengerName;
    private String gender;
    private int age;
    private String mealPreference;
    private double luggageWeight;
    private Long bookingId;   // FK only
}
