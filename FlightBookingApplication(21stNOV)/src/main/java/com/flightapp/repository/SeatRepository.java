package com.flightapp.repository;

import com.flightapp.model.Seat;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface SeatRepository extends ReactiveCrudRepository<Seat, Long> {

    Flux<Seat> findByFlightId(Long flightId);

    Flux<Seat> findByFlightIdAndStatus(Long flightId, String status);
}
