package concurrencydemo;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Simulation:");
        System.out.println("1. Bank Transfer (Race Condition Prevention)");
        System.out.println("2. Hotel Booking Deadlock Demo");
        System.out.println("3. Hotel Booking Deadlock Solved");
        System.out.print("Enter option: ");
        int ch = sc.nextInt();

        switch (ch) {
            case 1 -> BankSimulation.runBankDemo();
            case 2 -> HotelSimulation.deadlockDemo();
            case 3 -> HotelSimulation.deadlockSolved();
            default -> System.out.println("Invalid Option");
        }
    }
}
