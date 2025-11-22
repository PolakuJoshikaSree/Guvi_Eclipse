package com.flightapp.controller;

import com.flightapp.model.Booking;
import com.flightapp.request.BookingRequest;
import com.flightapp.service.BookingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingControllerTest {

    @Mock
    private BookingService service;

    @InjectMocks
    private BookingController controller;

    @Test
    void testBookFlight() {
        BookingRequest req = new BookingRequest();
        req.setEmail("test@gmail.com");
        req.setSeats(2);
        req.setPrimaryPassenger("John");

        Booking mock = new Booking();
        mock.setPnr("ABC123");

        when(service.book(1L, req)).thenReturn(Mono.just(mock));

        Booking result = controller.book(1L, req).block();

        assertEquals("ABC123", result.getPnr());
    }

    @Test
    void testGetBooking() {
        Booking b = new Booking();
        b.setPnr("XYZ789");

        when(service.getBooking("XYZ789")).thenReturn(Mono.just(b));

        Booking result = controller.getBooking("XYZ789").block();

        assertEquals("XYZ789", result.getPnr());
    }

    @Test
    void testCancelBooking() {
        when(service.cancelBooking("PNR123")).thenReturn(Mono.empty());

        controller.cancelBooking("PNR123").block();

        verify(service, times(1)).cancelBooking("PNR123");
    }
}
