package com.flightapp.controller;

import com.flightapp.model.Airline;
import com.flightapp.request.AddAirlineRequest;
import com.flightapp.service.AirlineService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airlines")
public class AirlineController {

    private final AirlineService service;

    public AirlineController(AirlineService service) {
        this.service = service;
    }

    // ADD A NEW AIRLINE
    @PostMapping("/add")
    public Airline addAirline(@Valid @RequestBody AddAirlineRequest request) {
        return service.addAirline(request);
    }

    // GET ALL AIRLINES
    @GetMapping("/all")
    public List<Airline> getAll() {
        return service.getAll();
    }

    // GET AIRLINE BY CODE
    @GetMapping("/{code}")
    public Airline getByCode(@PathVariable String code) {
        return service.getAirlineByCode(code);
    }
}
