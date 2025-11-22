package com.flightapp.controller;

import com.flightapp.model.Payment;
import com.flightapp.request.PaymentRequest;
import com.flightapp.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PaymentControllerTest {

    @Mock
    private PaymentService service;

    @InjectMocks
    private PaymentController controller;

    @Test
    void testPay() {
        PaymentRequest req = new PaymentRequest();
        req.setAmount(5000);
        req.setPaymentMode("CARD");

        Payment pay = new Payment();
        pay.setAmount(5000);
        pay.setPaymentTime(LocalDateTime.now());

        when(service.pay("ABC123", req)).thenReturn(pay);

        Payment result = controller.pay("ABC123", req);

        assertEquals(5000, result.getAmount());
        verify(service, times(1)).pay("ABC123", req);
    }
}

