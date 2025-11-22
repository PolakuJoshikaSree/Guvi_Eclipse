package com.flightapp.repository;

import com.flightapp.model.Booking;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookingRepository extends ReactiveCrudRepository<Booking, Long> {

    Mono<Booking> findByPnr(String pnr);

    Flux<Booking> findByEmailOrderByBookingTimeDesc(String email);
}
