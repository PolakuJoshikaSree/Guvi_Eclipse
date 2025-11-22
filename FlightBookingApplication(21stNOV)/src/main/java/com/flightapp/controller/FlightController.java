package com.flightapp.controller;

import com.flightapp.model.Flight;
import com.flightapp.request.AddFlightRequest;
import com.flightapp.request.FlightSearchRequest;
import com.flightapp.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService service;

    @PostMapping("/add")
    public Mono<Flight> addFlight(@RequestBody AddFlightRequest req) {
        return service.addFlight(req);
    }

    @PostMapping("/search")
    public Flux<Flight> searchFlights(@RequestBody FlightSearchRequest req) {
        return service.searchFlights(req);
    }

    @GetMapping("/{id}")
    public Mono<Flight> getFlight(@PathVariable Long id) {
        return service.getFlightById(id);
    }

    @PutMapping("/update/{id}")
    public Mono<Flight> updateFlight(@PathVariable Long id,
                                     @RequestBody AddFlightRequest req) {
        return service.updateFlight(id, req);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteFlight(@PathVariable Long id) {
        return service.deleteFlight(id);
    }
}
