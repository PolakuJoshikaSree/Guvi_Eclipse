package com.flightapp.controller;

import com.flightapp.model.Booking;
import com.flightapp.request.BookingRequest;
import com.flightapp.service.BookingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookingControllerTest {

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

        Booking mockBooking = new Booking();
        mockBooking.setPnr("ABC123");

        when(service.book(1L, req)).thenReturn(mockBooking);

        Booking b = controller.book(1L, req);

        assertEquals("ABC123", b.getPnr());
    }

    @Test
    void testGetBooking() {
        Booking b = new Booking();
        b.setPnr("XYZ789");

        when(service.getBooking("XYZ789")).thenReturn(b);

        Booking result = controller.get("XYZ789");

        assertEquals("XYZ789", result.getPnr());
    }

    @Test
    void testCancelBooking() {
        String msg = controller.cancel("PNR123");

        verify(service, times(1)).cancelBooking("PNR123");

        assertEquals("Booking cancelled.", msg);
    }
}
