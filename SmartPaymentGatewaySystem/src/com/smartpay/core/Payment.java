package com.smartpay.core;

import com.smartpay.utils.LoggerUtil;
import com.smartpay.exceptions.*;

public abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract void processPayment() throws TransactionFailedException;
}
