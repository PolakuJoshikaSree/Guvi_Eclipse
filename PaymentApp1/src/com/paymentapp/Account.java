package com.paymentapp;

import java.util.Objects;

public class Account implements Comparable<Account> {
    private String accountHolderName;
    private String accountNo;
    private String transCode;
    private String country;
    private String ifscCode;
    private double balance;

    public Account(String accountHolderName, String accountNo, String transCode, 
                   String country, String ifscCode, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNo = accountNo;
        this.transCode = transCode;
        this.country = country;
        this.ifscCode = ifscCode;
        this.balance = balance;
    }

    // Getters for sorting
    public String getAccountNo() { return accountNo; }
    public double getBalance() { return balance; }
    public String getAccountHolderName() { return accountHolderName; }

    // Comparable: Sort by accountHolderName
    @Override
    public int compareTo(Account other) {
        return this.accountHolderName.compareTo(other.accountHolderName);
    }

    // Equals and hashCode based on accountHolderName and accountNo
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(accountHolderName, account.accountHolderName)
                && Objects.equals(accountNo, account.accountNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderName, accountNo);
    }

    @Override
    public String toString() {
        return accountHolderName + " | " + accountNo + " | " + balance;
    }
}