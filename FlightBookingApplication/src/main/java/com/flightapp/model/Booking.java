package com.flightapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("bookings")
public class Booking {

    @Id
    private Long id;

    private String pnr;
    private Long flightId;    // R2DBC only stores FK value
    private String email;
    private String primaryPassenger;
    private int seatsBooked;
    private LocalDateTime bookingTime;
    private String status;
}
