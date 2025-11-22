package com.flightapp.controller;

import com.flightapp.model.Booking;
import com.flightapp.request.BookingRequest;
import com.flightapp.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping("/book/{flightId}")
    public Booking book(
            @PathVariable Long flightId,
            @Valid @RequestBody BookingRequest req
    ) {
        return service.book(flightId, req);
    }

    @GetMapping("/{pnr}")
    public Booking get(@PathVariable String pnr) {
        return service.getBooking(pnr);
    }

    @PutMapping("/cancel/{pnr}")
    public String cancel(@PathVariable String pnr) {
        service.cancelBooking(pnr);
        return "Booking cancelled.";
    }
}
