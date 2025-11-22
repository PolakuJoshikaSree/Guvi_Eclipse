package com.flightapp.service;

import com.flightapp.exception.ResourceNotFoundException;
import com.flightapp.model.Airline;
import com.flightapp.repository.AirlineRepository;
import com.flightapp.request.AddAirlineRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {

    private final AirlineRepository repo;

    public AirlineService(AirlineRepository repo) {
        this.repo = repo;
    }

    // ADD AIRLINE
    public Airline addAirline(AddAirlineRequest request) {

        Airline airline = new Airline();
        airline.setAirlineName(request.getAirlineName());
        airline.setAirlineCode(request.getAirlineCode());
        airline.setCountry(request.getCountry());

        return repo.save(airline);
    }

    // GET ALL AIRLINES
    public List<Airline> getAll() {
        return repo.findAll();
    }

    // GET AIRLINE BY CODE
    public Airline getAirlineByCode(String code) {
        return repo.findByAirlineCode(code)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Airline not found with code: " + code));
    }
}
