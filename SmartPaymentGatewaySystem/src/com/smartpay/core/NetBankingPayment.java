package com.smartpay.core;

import com.smartpay.utils.LoggerUtil;
import com.smartpay.exceptions.*;
import java.util.Scanner;

public class NetBankingPayment extends Payment {

    private static final String CORRECT_PASSWORD = "pass@123"; // predefined password

    public NetBankingPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() throws TransactionFailedException {
        LoggerUtil.log("Processing NetBanking payment of ₹" + amount);
        Scanner sc = new Scanner(System.in);

        try {
            if (amount <= 0) {
                throw new InvalidAmountException("Amount must be greater than 0");
            }
            System.out.print("Enter Bank Password: ");
            String enteredPassword = sc.nextLine();

            if (!CORRECT_PASSWORD.equals(enteredPassword)) {
                throw new InvalidCredentialsException("Invalid NetBanking Password");
            }

            LoggerUtil.log("NetBanking payment successful!");

        } catch (InvalidAmountException | InvalidCredentialsException e) {
            throw new TransactionFailedException("NetBanking Transaction Failed", e);
        } catch (Exception e) {
            throw new TransactionFailedException("Unexpected NetBanking Error", e);
        }
    }
}
