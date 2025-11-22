package com.flightapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("seats")
public class Seat {

    @Id
    private Long id;

    private String seatNumber;

    private String status;      

    private Long flightId;
}
