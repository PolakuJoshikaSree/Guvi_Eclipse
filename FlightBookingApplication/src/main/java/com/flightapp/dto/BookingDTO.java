package com.flightapp.dto;

import java.time.LocalDateTime;
import java.util.List;

public class BookingDTO {

    private Long id;
    private String pnr;
    private String email;
    private String primaryPassenger;
    private int seatsBooked;
    private LocalDateTime bookingTime;
    private String status;
    private Long flightId;
    private List<PassengerDTO> passengers;

    public BookingDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

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

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public List<PassengerDTO> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerDTO> passengers) {
        this.passengers = passengers;
    }
}
