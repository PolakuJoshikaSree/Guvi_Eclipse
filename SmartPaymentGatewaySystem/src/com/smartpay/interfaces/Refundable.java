package com.smartpay.interfaces;

import com.smartpay.exceptions.TransactionFailedException;

public interface Refundable {
    boolean refund(String transactionId, double amount) throws TransactionFailedException;
}
