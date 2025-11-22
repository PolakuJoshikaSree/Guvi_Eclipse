 package concurrencydemo;

class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public synchronized void withdraw(String user, int amount) {
        if (balance >= amount) {
            System.out.println(user + " is withdrawing " + amount);
            try { Thread.sleep(1000); } catch (Exception ignored) {}
            balance -= amount;
            System.out.println(user + " withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println(user + " attempted to withdraw " + amount + " but balance is insufficient!");
        }
    }
}
public class BankSimulation {
    public static void runBankDemo() {
        BankAccount account = new BankAccount(1000);

        Thread user1 = new Thread(() -> account.withdraw("User1", 700));
        Thread user2 = new Thread(() -> account.withdraw("User2", 700));

        user1.start();
        user2.start();

        try { user1.join(); user2.join(); } catch (Exception ignored) {}
    }
}
