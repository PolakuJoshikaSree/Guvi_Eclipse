package com.smartpay.core;

import com.smartpay.utils.LoggerUtil;
import com.smartpay.exceptions.*;

public class WalletPayment extends Payment {

    private double walletBalance = 100.0; 

    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() throws TransactionFailedException {
        LoggerUtil.log("Processing Wallet payment of ₹" + amount);
        try {
            if (amount <= 0) {
                throw new InvalidAmountException("Amount must be greater than 0");
            }
            if (walletBalance < amount) {
                throw new InsufficientBalanceException(
                    "Insufficient Wallet Balance. Available: ₹" + walletBalance
                );
            }
            walletBalance -= amount;
            LoggerUtil.log("Wallet payment successful! Remaining balance: ₹" + walletBalance);

        } catch (InvalidAmountException | InsufficientBalanceException e) {
            throw new TransactionFailedException("Wallet Transaction Failed,Insufficent Balanceupiuser@oksb", e);
        } catch (Exception e) {
            throw new TransactionFailedException("Unexpected Wallet Error", e);
        }
    }
}
