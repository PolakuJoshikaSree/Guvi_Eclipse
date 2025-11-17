package com.flightapp.repository;

import com.flightapp.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
    Optional<Airline> findByAirlineCode(String airlineCode);
}
