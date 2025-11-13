package com.smartpay.app;

import java.util.Scanner;
import com.smartpay.core.*;
import com.smartpay.utils.LoggerUtil;
import com.smartpay.model.BeneficiaryManager;
import com.smartpay.exceptions.*;

public class SmartPaymentApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BeneficiaryManager manager = new BeneficiaryManager();

        LoggerUtil.log("Welcome to Smart Payment Gateway System!");

        System.out.print("Enter beneficiary UPI ID to add: ");
        String upiId = sc.nextLine();
        System.out.print("Enter beneficiary name: ");
        String name = sc.nextLine();
        manager.addBeneficiary(name, upiId);

        System.out.print("Enter amount to pay: ");
        double amount = sc.nextDouble();

        LoggerUtil.log("Select payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.println("3. Wallet");
        System.out.println("4. NetBanking");

        int choice = sc.nextInt();
        Payment payment = null;

        switch (choice) {
            case 1: payment = new CreditCardPayment(amount); break;
            case 2: payment = new UPIPayment(amount); break;
            case 3: payment = new WalletPayment(amount); break;
            case 4: payment = new NetBankingPayment(amount); break;
            default:
                LoggerUtil.error("Invalid choice");
                sc.close();
                return;
        }

        try {
            payment.processPayment();
        } catch (TransactionFailedException e) {
            LoggerUtil.error("Transaction failed: " + e.getMessage());
        } catch (Exception e) {
            LoggerUtil.error("Error: " + e.getMessage());
        }

        sc.close();
        LoggerUtil.log("Thank you for using Smart Payment Gateway!");
    }
}
