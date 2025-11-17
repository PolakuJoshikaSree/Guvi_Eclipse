package com.flightapp.service;

import com.flightapp.model.Booking;
import com.flightapp.model.Flight;
import com.flightapp.model.Passenger;
import com.flightapp.model.enums.Gender;
import com.flightapp.repository.BookingRepository;
import com.flightapp.repository.PassengerRepository;
import com.flightapp.request.BookingRequest;
import com.flightapp.request.PassengerRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepo;

    @Mock
    private PassengerRepository passengerRepo;

    @Mock
    private FlightService flightService;

    @InjectMocks
    private BookingService service;

    @Test
    void testBook() {
        Flight flight = new Flight();
        flight.setBookedSeats(0);
        flight.setTotalSeats(100);

        when(flightService.getFlightById(1L)).thenReturn(flight);
        when(bookingRepo.save(any(Booking.class))).thenReturn(new Booking());
        when(passengerRepo.save(any(Passenger.class))).thenReturn(new Passenger());

        BookingRequest req = new BookingRequest();
        req.setEmail("test@gmail.com");
        req.setPrimaryPassenger("John");
        req.setSeats(2);

        PassengerRequest p = new PassengerRequest();
        p.setName("John");
        p.setGender(Gender.MALE);
        p.setAge(25);
        p.setLuggageWeight(15);

        req.setPassengers(List.of(p));

        Booking result = service.book(1L, req);

        assertNotNull(result);
        verify(bookingRepo, times(1)).save(any(Booking.class));
    }

    @Test
    void testGetBooking_notFound() {
        when(bookingRepo.findByPnr("XX")).thenReturn(java.util.Optional.empty());

        assertThrows(RuntimeException.class, () -> service.getBooking("XX"));
    }
}
