package com.smartpay.exceptions;

public class PaymentGatewayTimeoutException extends Exception {
    public PaymentGatewayTimeoutException(String message) {
        super(message);
    }
}
