package com.flightapp.controller;

import com.flightapp.model.Airline;
import com.flightapp.request.AddAirlineRequest;
import com.flightapp.service.AirlineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/airlines")
public class AirlineController {

    private final AirlineService service;

    @PostMapping("/add")
    public Mono<Airline> add(@RequestBody AddAirlineRequest req) {
        return service.addAirline(req);
    }

    @GetMapping("/all")
    public Flux<Airline> all() {
        return service.getAll();
    }

    @GetMapping("/{code}")
    public Mono<Airline> getByCode(@PathVariable String code) {
        return service.getAirlineByCode(code);
    }

    @PutMapping("/update/{code}")
    public Mono<Airline> update(@PathVariable String code,
                                @RequestBody AddAirlineRequest request) {
        return service.updateAirline(code, request);
    }

    @DeleteMapping("/{code}")
    public Mono<Void> deleteByCode(@PathVariable String code) {
        return service.deleteAirline(code);
    }

    @DeleteMapping("/id/{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return service.deleteAirlineById(id);
    }
}
