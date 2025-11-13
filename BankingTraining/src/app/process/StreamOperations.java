package com.app.process;

import com.app.dto.Account;
import java.util.*;
import java.util.stream.Collectors;

public class StreamOperations {

    public static List<Account> sortByBalance(List<Account> accounts, boolean descending) {
        Comparator<Account> comparator = Comparator.comparingDouble(Account::balance);
        if (descending) comparator = comparator.reversed();
        return accounts.stream().sorted(comparator).collect(Collectors.toList());
    }

    public static List<Account> sortByAccountNumber(List<Account> accounts) {
        return accounts.stream()
                .sorted(Comparator.comparing(Account::accountNumber))
                .collect(Collectors.toList());
    }

    public static void displayAccounts(List<Account> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found!");
            return;
        }
        accounts.forEach(a ->
                System.out.println("AccountNo: " + a.accountNumber() + " | Balance: ₹" + a.balance()));
    }
}
