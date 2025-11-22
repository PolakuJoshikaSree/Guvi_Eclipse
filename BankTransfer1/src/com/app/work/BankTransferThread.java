package com.app.work;

class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public synchronized void transfer(int amount) {
        if (amount <= 0) {
            System.out.println(Thread.currentThread().getName() + " tried invalid amount");
            return;
        }

        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is transferring ₹" + amount);
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed transfer. Remaining: ₹" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried ₹" + amount + " but insufficient funds!");
        }
    }

    public int getBalance() {
        return balance;
    }
}

class TransferTask implements Runnable {
    private Account account;
    private int amount;

    public TransferTask(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        account.transfer(amount);
    }
}

public class BankTransferThread {
    public static void main(String[] args) throws InterruptedException {

        Account account = new Account(1000);

        Thread t1 = new Thread(new TransferTask(account, 700), "User-1");
        Thread t2 = new Thread(new TransferTask(account, 700), "User-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("✅ Final Balance: ₹" + account.getBalance());
    }
}
