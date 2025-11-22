package com.app;

import com.app.dto.*;
import com.app.features.PaymentsOps;
import com.app.process.StreamOperations;

import java.util.*;

public class FundTransfer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();

        System.out.println("=== 🏦 Welcome to Chubb Banking System ===");
        System.out.print("Enter number of accounts to create: ");
        int numAccounts = scanner.nextInt();
        scanner.nextLine();

        //  Take account details
        for (int i = 0; i < numAccounts; i++) {
            System.out.println("\nEnter details for Account " + (i + 1) + ":");
            System.out.print("Account Number: ");
            String accNo = scanner.nextLine();

            System.out.print("Initial Balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Number of Beneficiaries: ");
            int numBen = scanner.nextInt();
            scanner.nextLine();

            List<Beneficiary> beneficiaries = new ArrayList<>();
            for (int j = 0; j < numBen; j++) {
                System.out.println("Beneficiary " + (j + 1) + ":");
                System.out.print("Name: ");
                String benName = scanner.nextLine();
                System.out.print("Account Number: ");
                String benAcc = scanner.nextLine();
                beneficiaries.add(new Beneficiary(benName, benAcc));
            }

            accounts.add(new Account(accNo, balance, beneficiaries));
        }

        //  Menu
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Fund Transfer");
            System.out.println("2. Sort Accounts by Balance");
            System.out.println("3. Sort Accounts by Account Number");
            System.out.println("4. Display All Accounts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Sender Account Number: ");
                    String senderAcc = scanner.nextLine();
                    Optional<Account> senderOpt = accounts.stream()
                            .filter(a -> a.accountNumber().equals(senderAcc))
                            .findFirst();

                    if (senderOpt.isEmpty()) {
                        System.out.println("❌ Sender account not found.");
                        continue;
                    }

                    Account sender = senderOpt.get();

                    if (sender.beneficiaries().isEmpty()) {
                        System.out.println("❌ No beneficiaries found for this account.");
                        continue;
                    }

                    System.out.println("Available Beneficiaries:");
                    sender.beneficiaries().forEach(b ->
                            System.out.println(" - " + b.name() + " (AccNo: " + b.beneficiaryAccountNo() + ")"));

                    System.out.print("Enter Beneficiary Account Number: ");
                    String benAcc = scanner.nextLine();
                    System.out.print("Enter Transfer Amount: ");
                    double amt = scanner.nextDouble();
                    scanner.nextLine();

                    PaymentsOps paymentOps = new PaymentsOps();
                    Account updatedSender = paymentOps.fundTransfer(sender, benAcc, amt);

                    // Update sender balance in list
                    accounts.replaceAll(a -> a.accountNumber().equals(updatedSender.accountNumber()) ? updatedSender : a);
                }

                case 2 -> {
                    System.out.println("\n=== Accounts Sorted by Balance (Descending) ===");
                    var sorted = StreamOperations.sortByBalance(accounts, true);
                    StreamOperations.displayAccounts(sorted);
                }

                case 3 -> {
                    System.out.println("\n=== Accounts Sorted by Account Number (Ascending) ===");
                    var sorted = StreamOperations.sortByAccountNumber(accounts);
                    StreamOperations.displayAccounts(sorted);
                }

                case 4 -> {
                    System.out.println("\n=== All Accounts ===");
                    StreamOperations.displayAccounts(accounts);
                }

                case 5 -> {
                    System.out.println("🏦 Thank you for using Chubb Banking System!");
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
