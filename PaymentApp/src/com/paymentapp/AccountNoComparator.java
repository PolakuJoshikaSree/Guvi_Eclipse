package com.paymentapp;

import java.util.Comparator;

// Sort by Account Number
public class AccountNoComparator implements Comparator<Account> {
    @Override
    public int compare(Account a1, Account a2) {
        return a1.getAccountNo().compareTo(a2.getAccountNo());
    }
}
