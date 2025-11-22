package com.flightapp.controller;

import com.flightapp.model.Payment;
import com.flightapp.request.PaymentRequest;
import com.flightapp.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    @PostMapping("/pay/{pnr}")
    public Mono<Payment> pay(@PathVariable String pnr,
                             @RequestBody PaymentRequest req) {
        return service.pay(pnr, req);
    }

    @GetMapping("/{id}")
    public Mono<Payment> get(@PathVariable Long id) {
        return service.getPayment(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return service.deletePayment(id);
    }
}
