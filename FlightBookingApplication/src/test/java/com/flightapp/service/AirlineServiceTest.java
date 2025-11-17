package com.flightapp.service;

import com.flightapp.exception.ResourceNotFoundException;
import com.flightapp.model.Airline;
import com.flightapp.repository.AirlineRepository;
import com.flightapp.request.AddAirlineRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AirlineServiceTest {

    @Mock
    private AirlineRepository repo;

    @InjectMocks
    private AirlineService service;

    @Test
    void testAddAirline() {
        AddAirlineRequest req = new AddAirlineRequest();
        req.setAirlineName("Air India");
        req.setAirlineCode("AI101");
        req.setCountry("India");

        Airline saved = new Airline();
        saved.setAirlineName("Air India");

        when(repo.save(any(Airline.class))).thenReturn(saved);

        Airline result = service.addAirline(req);

        assertEquals("Air India", result.getAirlineName());
        verify(repo, times(1)).save(any(Airline.class));
    }

    @Test
    void testGetAirlineByCode_found() {
        Airline airline = new Airline();
        airline.setAirlineCode("AI101");

        when(repo.findByAirlineCode("AI101")).thenReturn(Optional.of(airline));

        Airline result = service.getAirlineByCode("AI101");

        assertEquals("AI101", result.getAirlineCode());
    }

    @Test
    void testGetAirlineByCode_notFound() {
        when(repo.findByAirlineCode("XX")).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.getAirlineByCode("XX"));
    }
}
