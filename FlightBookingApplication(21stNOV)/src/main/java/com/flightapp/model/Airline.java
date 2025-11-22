package com.flightapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("airlines")
public class Airline {

    @Id
    private Long id;

    private String airlineName;
    private String airlineCode;
    private String country;
}
