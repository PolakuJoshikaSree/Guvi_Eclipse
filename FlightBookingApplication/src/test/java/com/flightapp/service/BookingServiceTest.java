package com.flightapp.service;

import com.flightapp.model.Booking;
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

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

        // Mock flight
        when(flightService.getFlightById(1L))
                .thenReturn(Mono.just(new com.flightapp.model.Flight()));

        // Mock booking save
        Booking savedBooking = new Booking();
        savedBooking.setId(10L);

        when(bookingRepo.save(any()))
                .thenReturn(Mono.just(savedBooking));

        // Mock passenger saveAll
        when(passengerRepo.saveAll(anyList()))
                .thenReturn(Flux.fromIterable(List.of(new Passenger())));

        // Prepare request
        PassengerRequest p = new PassengerRequest();
        p.setName("John");
        p.setAge(22);
        p.setGender(Gender.MALE);
        p.setLuggageWeight(10);

        BookingRequest req = new BookingRequest();
        req.setEmail("abc@gmail.com");
        req.setPrimaryPassenger("John");
        req.setSeats(1);
        req.setPassengers(List.of(p));

        // Call service
        Booking result = service.book(1L, req).block();

        // Assertions
        assertNotNull(result);

        verify(bookingRepo, times(1)).save(any());
        verify(passengerRepo, times(1)).saveAll(anyList());
        verify(flightService, times(1)).getFlightById(1L);
    }


    @Test
    void testGetBooking_notFound() {
        when(bookingRepo.findByPnr("XX"))
                .thenReturn(Mono.empty());

        Booking result = service.getBooking("XX").block();

        assertNull(result); // because your service doesn't throw exception
    }
}
