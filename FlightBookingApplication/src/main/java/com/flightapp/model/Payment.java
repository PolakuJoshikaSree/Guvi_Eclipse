package com.flightapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("payments")
public class Payment {

    @Id
    private Long id;

    private double amount;
    private String paymentMode;
    private LocalDateTime paymentTime;
    private String status;
    private Long bookingId;
}
