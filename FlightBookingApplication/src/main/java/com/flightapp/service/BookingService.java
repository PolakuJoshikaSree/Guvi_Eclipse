package com.flightapp.service;

import com.flightapp.model.Booking;
import com.flightapp.model.Passenger;
import com.flightapp.model.Flight;
import com.flightapp.model.enums.BookingStatus;
import com.flightapp.repository.BookingRepository;
import com.flightapp.repository.PassengerRepository;
import com.flightapp.request.BookingRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class BookingService {

    private final BookingRepository bookingRepo;
    private final PassengerRepository passengerRepo;
    private final FlightService flightService;

    public BookingService(BookingRepository bookingRepo,
                          PassengerRepository passengerRepo,
                          FlightService flightService) {
        this.bookingRepo = bookingRepo;
        this.passengerRepo = passengerRepo;
        this.flightService = flightService;
    }

    @Transactional
    public Booking book(Long flightId, BookingRequest req) {

        Flight flight = flightService.getFlightById(flightId);

        if (flight.getAvailableSeats() < req.getSeats()) {
            throw new RuntimeException("Not enough seats");
        }

        Booking booking = new Booking();
        booking.setPnr(UUID.randomUUID().toString().substring(0, 8).toUpperCase());
        booking.setEmail(req.getEmail());
        booking.setPrimaryPassenger(req.getPrimaryPassenger());
        booking.setSeatsBooked(req.getSeats());
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setFlight(flight);

        bookingRepo.save(booking);

        // save passengers
        req.getPassengers().forEach(p -> {
            Passenger ps = new Passenger();
            ps.setPassengerName(p.getName());
            ps.setGender(p.getGender());
            ps.setAge(p.getAge());
            ps.setLuggageWeight(p.getLuggageWeight());
            ps.setMealPreference(p.getMealPreference());
            ps.setBooking(booking);
            passengerRepo.save(ps);
        });

        // update seats
        flight.setBookedSeats(flight.getBookedSeats() + req.getSeats());

        return booking;
    }

    public Booking getBooking(String pnr) {
        return bookingRepo.findByPnr(pnr)
                .orElseThrow(() -> new RuntimeException("PNR not found"));
    }

    public void cancelBooking(String pnr) {
        Booking b = getBooking(pnr);
        b.setStatus(BookingStatus.CANCELLED);
        bookingRepo.save(b);
    }
}
