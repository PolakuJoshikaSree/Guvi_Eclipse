package com.flightapp.repository;

import com.flightapp.model.Seat;
import com.flightapp.model.enums.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    List<Seat> findByFlightIdAndStatus(Long flightId, SeatStatus status);
}
