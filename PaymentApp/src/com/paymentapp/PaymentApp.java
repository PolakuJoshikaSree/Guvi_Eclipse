package com.paymentapp;

import java.util.*;

public class PaymentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Account> accountList = new ArrayList<>();

        System.out.print("Enter number of accounts to add: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Account " + (i + 1) + ":");
            System.out.print("Account Holder Name: ");
            String name = scanner.nextLine();

            System.out.print("Account No: ");
            String accountNo = scanner.nextLine();

            System.out.print("Transaction Code: ");
            String transCode = scanner.nextLine();

            System.out.print("Country: ");
            String country = scanner.nextLine();

            System.out.print("IFSC Code: ");
            String ifscCode = scanner.nextLine();

            System.out.print("Balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine(); 

            Account acc = new Account(name, accountNo, transCode, country, ifscCode, balance);
            accountList.add(acc);
        }
        System.out.println("\nAll Accounts:");
        accountList.forEach(System.out::println);
        accountList.sort(new AccountNoComparator());
        System.out.println("\nSorted by Account No:");
        accountList.forEach(System.out::println);
        accountList.sort(new BalanceComparator());
        System.out.println("\nSorted by Balance:");
        accountList.forEach(System.out::println);
        Collections.sort(accountList);
        System.out.println("\nSorted by Account Holder Name (Comparable):");
        accountList.forEach(System.out::println);
    }
}
