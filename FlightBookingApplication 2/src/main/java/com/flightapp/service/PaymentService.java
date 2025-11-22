package com.flightapp.service;

import com.flightapp.model.Booking;
import com.flightapp.model.Payment;
import com.flightapp.model.enums.PaymentStatus;
import com.flightapp.repository.PaymentRepository;
import com.flightapp.request.PaymentRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final BookingService bookingService;
    private final PaymentRepository paymentRepository;

    public PaymentService(BookingService bookingService,
                          PaymentRepository paymentRepository) {
        this.bookingService = bookingService;
        this.paymentRepository = paymentRepository;
    }

    public Payment pay(String pnr, PaymentRequest req) {

        Booking booking = bookingService.getBooking(pnr);

        Payment payment = new Payment();
        payment.setAmount(req.getAmount());
        payment.setPaymentMode(req.getPaymentMode());
        payment.setPaymentTime(LocalDateTime.now());
        payment.setStatus(PaymentStatus.SUCCESS);
        payment.setBooking(booking);

        return paymentRepository.save(payment);
    }
}
