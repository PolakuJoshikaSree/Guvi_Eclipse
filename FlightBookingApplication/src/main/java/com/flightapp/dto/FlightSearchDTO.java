package com.flightapp.dto;

import java.time.LocalDate;

public class FlightSearchDTO {

    private String from;
    private String to;
    private LocalDate date;

    public FlightSearchDTO() {}

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
