package com.flightapp.repository;

import com.flightapp.model.Flight;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDate;

public interface FlightRepository extends ReactiveCrudRepository<Flight, Long> {

    Flux<Flight> findByFromPlaceAndToPlaceAndFlightDate(
            String fromPlace,
            String toPlace,
            LocalDate flightDate
    );
}
