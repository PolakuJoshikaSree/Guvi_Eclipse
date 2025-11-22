package com.app.features;

import com.app.dto.Account;
import com.app.dto.Beneficiary;
import java.util.Optional;

public class PaymentsOps {

    public Account fundTransfer(Account sender, String beneficiaryAccountNo, double amount) {
        Optional<Beneficiary> match = sender.beneficiaries().stream()
                .filter(b -> b.beneficiaryAccountNo().equals(beneficiaryAccountNo))
                .findFirst();

        if (match.isEmpty()) {
            System.out.println("❌ Beneficiary not found.");
            return sender;
        }
        if (amount <= 0) {
            System.out.println("❌ Amount must be positive.");
            return sender;
        }
        if (sender.balance() < amount) {
            System.out.println("❌ Insufficient balance.");
            return sender;
        }

        double newBalance = sender.balance() - amount;
        System.out.println("\n✅ Transfer Successful!");
        System.out.println("Sender New Balance: ₹" + newBalance);
        System.out.println("Beneficiary " + match.get().name() + " (AccNo: " + beneficiaryAccountNo + ") credited with ₹" + amount);

        return new Account(sender.accountNumber(), newBalance, sender.beneficiaries());
    }
}

