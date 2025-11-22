package com.flightapp.controller;

import com.flightapp.model.Airline;
import com.flightapp.request.AddAirlineRequest;
import com.flightapp.service.AirlineService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AirlineControllerTest {

    @Mock
    private AirlineService service;

    @InjectMocks
    private AirlineController controller;

    @Test
    void testAddAirline() {
        AddAirlineRequest req = new AddAirlineRequest();
        req.setAirlineName("Indigo");
        req.setAirlineCode("6E");
        req.setCountry("India");

        Airline mockAirline = new Airline();
        mockAirline.setAirlineName("Indigo");

        when(service.addAirline(req)).thenReturn(mockAirline);

        Airline result = controller.addAirline(req);

        assertEquals("Indigo", result.getAirlineName());
        verify(service, times(1)).addAirline(req);
    }

    @Test
    void testGetAllAirlines() {
        when(service.getAll()).thenReturn(List.of(new Airline(), new Airline()));

        List<Airline> res = controller.getAll();

        assertEquals(2, res.size());
        verify(service, times(1)).getAll();
    }

    @Test
    void testGetByCode() {
        Airline a = new Airline();
        a.setAirlineCode("AI");

        when(service.getAirlineByCode("AI")).thenReturn(a);

        Airline result = controller.getByCode("AI");

        assertEquals("AI", result.getAirlineCode());
    }
}
