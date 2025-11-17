package com.flightapp.service;

import com.flightapp.model.Airline;
import com.flightapp.model.Flight;
import com.flightapp.repository.AirlineRepository;
import com.flightapp.repository.FlightRepository;
import com.flightapp.request.AddFlightRequest;
import com.flightapp.request.FlightSearchRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepo;
    private final AirlineRepository airlineRepo;

    public FlightService(FlightRepository flightRepo, AirlineRepository airlineRepo) {
        this.flightRepo = flightRepo;
        this.airlineRepo = airlineRepo;
    }

    public Flight addFlight(AddFlightRequest req) {

        Airline airline = airlineRepo.findByAirlineCode(req.getAirlineCode())
                .orElseThrow(() -> new RuntimeException("Airline not found with code : " + req.getAirlineCode()));

        Flight f = new Flight();
        f.setFlightNumber(req.getFlightNumber());
        f.setFromPlace(req.getFromPlace());
        f.setToPlace(req.getToPlace());
        f.setFlightDate(LocalDate.parse(req.getFlightDate()));
        f.setDepartureTime(LocalTime.parse(req.getDepartureTime()));
        f.setArrivalTime(LocalTime.parse(req.getArrivalTime()));
        f.setTotalSeats(req.getTotalSeats());
        f.setBookedSeats(0);
        f.setPrice(req.getPrice());
        f.setBaggageLimitKg(req.getBaggageLimitKg());
        f.setAirline(airline);

        return flightRepo.save(f);
    }

    public List<Flight> searchFlights(FlightSearchRequest request) {
        LocalDate date = LocalDate.parse(request.getFlightDate()); // Convert String → LocalDate

        return flightRepo.findByFromPlaceAndToPlaceAndFlightDate(
                request.getFromPlace(),
                request.getToPlace(),
                date
        );
    }

    public Flight getFlightById(Long id) {
        return flightRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }
}

