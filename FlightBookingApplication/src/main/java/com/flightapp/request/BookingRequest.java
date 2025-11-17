package com.flightapp.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;

public class BookingRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String primaryPassenger;

    @Min(1)
    private int seats;

    @Valid
    private List<PassengerRequest> passengers;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrimaryPassenger() {
        return primaryPassenger;
    }

    public void setPrimaryPassenger(String primaryPassenger) {
        this.primaryPassenger = primaryPassenger;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public List<PassengerRequest> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerRequest> passengers) {
        this.passengers = passengers;
    }
}
