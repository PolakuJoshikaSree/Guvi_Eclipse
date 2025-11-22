package com.flightapp.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AddFlightRequest {

    @NotBlank
    private String flightNumber;

    @NotBlank
    private String fromPlace;

    @NotBlank
    private String toPlace;

    @NotBlank
    private String flightDate; // yyyy-MM-dd

    @NotBlank
    private String departureTime; // HH:mm

    @NotBlank
    private String arrivalTime; // HH:mm

    @NotNull
    private Integer totalSeats;

    @NotNull
    private Double price;

    @NotNull
    private Integer baggageLimitKg;

    @NotBlank
    private String airlineCode;

    public AddFlightRequest() {}

    public String getFlightNumber() { 
        return flightNumber; 
    }
    public void setFlightNumber(String flightNumber) { 
        this.flightNumber = flightNumber; 
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

    public String getFlightDate() { 
        return flightDate; 
    }
    public void setFlightDate(String flightDate) { 
        this.flightDate = flightDate; 
    }

    public String getDepartureTime() { 
        return departureTime; 
    }
    public void setDepartureTime(String departureTime) { 
        this.departureTime = departureTime; 
    }

    public String getArrivalTime() { 
        return arrivalTime; 
    }
    public void setArrivalTime(String arrivalTime) { 
        this.arrivalTime = arrivalTime; 
    }

    public Integer getTotalSeats() { 
        return totalSeats; 
    }
    public void setTotalSeats(Integer totalSeats) { 
        this.totalSeats = totalSeats; 
    }

    public Double getPrice() { 
        return price; 
    }
    public void setPrice(Double price) { 
        this.price = price; 
    }

    public Integer getBaggageLimitKg() { 
        return baggageLimitKg; 
    }
    public void setBaggageLimitKg(Integer baggageLimitKg) { 
        this.baggageLimitKg = baggageLimitKg; 
    }

    public String getAirlineCode() { 
        return airlineCode; 
    }
    public void setAirlineCode(String airlineCode) { 
        this.airlineCode = airlineCode; 
    }
}
