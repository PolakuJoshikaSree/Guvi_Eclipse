package com.smartpay.core;

import com.smartpay.utils.LoggerUtil;
import com.smartpay.exceptions.*;

public class CreditCardPayment extends Payment {
    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() throws TransactionFailedException {
        LoggerUtil.log("Processing Credit Card payment of ₹" + amount);
        if (amount <= 0) throw new InvalidAmountException("Invalid amount entered");
        LoggerUtil.log("Credit Card payment successful!");
    }
}
