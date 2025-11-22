package com.flightapp.controller;

import com.flightapp.model.Booking;
import com.flightapp.request.BookingRequest;
import com.flightapp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService service;

    @PostMapping("/book/{flightId}")
    public Mono<Booking> book(@PathVariable Long flightId,
                              @RequestBody BookingRequest req) {
        return service.book(flightId, req);
    }

    @GetMapping("/{pnr}")
    public Mono<Booking> getBooking(@PathVariable String pnr) {
        return service.getBooking(pnr);
    }

    @PutMapping("/cancel/{pnr}")
    public Mono<Void> cancelBooking(@PathVariable String pnr) {
        return service.cancelBooking(pnr);
    }

    @DeleteMapping("/{pnr}")
    public Mono<Void> deleteBooking(@PathVariable String pnr) {
        return service.deleteBooking(pnr);
    }
}
