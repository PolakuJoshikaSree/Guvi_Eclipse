package com.flightapp.controller;

import com.flightapp.model.Flight;
import com.flightapp.request.AddFlightRequest;
import com.flightapp.request.FlightSearchRequest;
import com.flightapp.service.FlightService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FlightControllerTest {

    @Mock
    private FlightService service;

    @InjectMocks
    private FlightController controller;

    @Test
    void testAddFlight() {
        AddFlightRequest req = new AddFlightRequest();
        req.setFlightNumber("AI101");

        Flight mock = new Flight();
        mock.setFlightNumber("AI101");

        when(service.addFlight(req)).thenReturn(mock);

        Flight result = controller.addFlight(req);

        assertEquals("AI101", result.getFlightNumber());
        verify(service, times(1)).addFlight(req);
    }

    @Test
    void testSearchFlights() {
        FlightSearchRequest req = new FlightSearchRequest();
        req.setFromPlace("Delhi");
        req.setToPlace("Mumbai");
        req.setFlightDate("2025-01-10");

        when(service.searchFlights(req))
                .thenReturn(List.of(new Flight(), new Flight()));

        List<Flight> flights = controller.search(req);

        assertEquals(2, flights.size());
    }
}
