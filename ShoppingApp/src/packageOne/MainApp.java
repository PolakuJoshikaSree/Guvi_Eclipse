package packageOne;


import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter car model (Alfa/Beta/Delta): ");
        String model = sc.nextLine();

        System.out.print("Enter car color: ");
        String color = sc.nextLine();

        Car car = new Car(model, color);

        // Loan details
        System.out.print("Enter loan amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter annual interest rate (%): ");
        double rate = sc.nextDouble();

        System.out.print("Enter loan duration (years): ");
        int years = sc.nextInt();

        System.out.print("Enter down payment: ");
        double downPayment = sc.nextDouble();

        Loan loan = new Loan(amount, rate, years, downPayment);

        System.out.println("CAR DETAILS ");
        System.out.println("Model: " + car.model);
        System.out.println("Color: " + car.color);
        System.out.println("Price: " + car.price);

        System.out.println(" LOAN DETAILS ");
        System.out.println("Loan Amount: " + loan.amount);
        System.out.println("Interest Rate: " + loan.rate + "%");
        System.out.println("Years: " + loan.years);
        System.out.println("Down Payment: " + loan.downPayment);

        System.out.println(" Simple Interest ");
        System.out.println("Total Amount (Simple): " + loan.totalAmount());
        System.out.println("Monthly EMI (Simple): " + String.format("%.2f", loan.emi()));

        System.out.println(" Compound Interest ");
        System.out.println("Total Amount (Compound): " + loan.compoundTotalAmount());
        System.out.println("Monthly EMI (Compound): " + String.format("%.2f", loan.compoundEmi()));

        sc.close();
    }
}