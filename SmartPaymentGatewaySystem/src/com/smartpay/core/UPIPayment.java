package com.smartpay.core;

import com.smartpay.utils.LoggerUtil;
import com.smartpay.exceptions.*;
import java.util.Scanner;

public class UPIPayment extends Payment {

    private static final String CORRECT_UPI_PIN = "1234"; // predefined correct PIN

    public UPIPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() throws TransactionFailedException {
        LoggerUtil.log("Processing UPI payment of ₹" + amount);
        Scanner sc = new Scanner(System.in); // ask input here

        try {
            if (amount <= 0) {
                throw new InvalidAmountException("Amount must be greater than 0");
            }

            // Ask for PIN during payment processing
            System.out.print("Enter UPI PIN: ");
            String enteredPin = sc.nextLine();

            if (!CORRECT_UPI_PIN.equals(enteredPin)) {
                throw new InvalidCredentialsException("Invalid UPI PIN");
            }

            LoggerUtil.log("UPI payment successful!");

        } catch (InvalidAmountException | InvalidCredentialsException e) {
            throw new TransactionFailedException("UPI Transaction Failed", e);
        } catch (Exception e) {
            throw new TransactionFailedException("Unexpected UPI Error", e);
        }
    }
}
