package com.business.main;

import com.business.exceptions.*;

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        try {
            acc.deposit(500);
            acc.withdraw(2000);
        } catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Final Balance: " + acc.getBalance());
    }
}
