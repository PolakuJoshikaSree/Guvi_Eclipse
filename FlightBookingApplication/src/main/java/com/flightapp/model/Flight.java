package com.flightapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Table("flights")
public class Flight {

    @Id
    private Long id;

    private String flightNumber;
    private String airlineCode;  // stored instead of @ManyToOne
    private String fromPlace;
    private String toPlace;
    private LocalDate flightDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private int totalSeats;
    private int bookedSeats;
    private double price;
    private String mealTypeAvailable;
    private double baggageLimitKg;
}
