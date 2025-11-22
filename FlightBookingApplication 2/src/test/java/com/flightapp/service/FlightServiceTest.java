package com.flightapp.service;

import com.flightapp.model.Airline;
import com.flightapp.model.Flight;
import com.flightapp.repository.AirlineRepository;
import com.flightapp.repository.FlightRepository;
import com.flightapp.request.AddFlightRequest;
import com.flightapp.request.FlightSearchRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FlightServiceTest {

    @Mock
    private FlightRepository flightRepo;

    @Mock
    private AirlineRepository airlineRepo;

    @InjectMocks
    private FlightService service;
    @Test
    void testAddFlight() {

        AddFlightRequest req = new AddFlightRequest();
        req.setAirlineCode("AI101");
        req.setFlightNumber("AI-10");
        req.setFromPlace("Delhi");
        req.setToPlace("Mumbai");
        req.setFlightDate("2025-12-01");
        req.setDepartureTime("10:00");
        req.setArrivalTime("12:00");
        req.setTotalSeats(180);
        req.setPrice(5000.0);
        req.setBaggageLimitKg(15);


        Airline airline = new Airline();
        airline.setAirlineCode("AI101");

        // Mock repo responses
        when(airlineRepo.findByAirlineCode("AI101"))
                .thenReturn(Optional.of(airline));

        when(flightRepo.save(any(Flight.class)))
                .thenReturn(new Flight());

        // Execute service
        Flight result = service.addFlight(req);

        // Assert
        assertNotNull(result);
        verify(flightRepo, times(1)).save(any(Flight.class));
    }
    @Test
    void testSearchFlights() {

        FlightSearchRequest req = new FlightSearchRequest();
        req.setFromPlace("Delhi");
        req.setToPlace("Mumbai");
        req.setFlightDate("2025-12-01");

        when(flightRepo.findByFromPlaceAndToPlaceAndFlightDate(
                "Delhi", "Mumbai", LocalDate.parse("2025-12-01")
        )).thenReturn(Collections.emptyList());

        var result = service.searchFlights(req);

        assertEquals(0, result.size());
        verify(flightRepo, times(1))
                .findByFromPlaceAndToPlaceAndFlightDate(
                        "Delhi", "Mumbai", LocalDate.parse("2025-12-01")
                );
    }
}
