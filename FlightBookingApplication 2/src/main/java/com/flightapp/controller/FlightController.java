package com.flightapp.controller;

import com.flightapp.model.Flight;
import com.flightapp.request.AddFlightRequest;
import com.flightapp.request.FlightSearchRequest;
import com.flightapp.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Flight addFlight(@Valid @RequestBody AddFlightRequest req) {
        return service.addFlight(req);
    }

    @PostMapping("/search")
    public List<Flight> search(@Valid @RequestBody FlightSearchRequest req) {
        return service.searchFlights(req);
    }
}
