package com.business.main;

import com.business.exceptions.*;

public class BankAccount {
    private double balance = 1000;

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException("Deposit must be positive!");
        balance += amount;
    }

    public void withdraw(double amount) throws BusinessException {
        if (amount <= 0) throw new InvalidAmountException("Invalid withdraw amount!");
        if (amount > balance) throw new InsufficientBalanceException("Not enough balance!");
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
