package com.bigboytoys;

import java.util.*;

// BillingApp is the main class that brings everything together.
// It’s responsible for user interaction, menu display, and Billing Summary.
//It shows the use of HashMap for storing brand to model to price.
 
public class BillingApp {

    public static void main(String[] args) {
    	//Scanner to read the brand,model,engine and insurance.

        Scanner sc = new Scanner(System.in);

        // Its nested HashMap,stores like the JSON sample data.
        // Outer HashMap for Brand name,Inner HashMap for model name.
        HashMap<String, HashMap<String, Double>> carData = new HashMap<>();

        carData.put("Ferrari", new HashMap<>(Map.of(
                "FerrariLaFerrari", 4000000.0,
                "458 Italia", 169995.0)));

        carData.put("Lamborghini", new HashMap<>(Map.of(
                "Sesto Elemento", 2200000.0)));

        carData.put("Lotus", new HashMap<>(Map.of(
                "Exige", 137510.0)));

        carData.put("Bentley", new HashMap<>(Map.of(
                "Continental GT", 160920.0)));

        carData.put("Rolls Royce", new HashMap<>(Map.of(
                "Wraith", 559570.0)));

        System.out.println("   Welcome to Big Boy Toys - Billing System  ");

        // Extract brand names from HashMap using keySet() and displays with numbers.
        List<String> brands = new ArrayList<>(carData.keySet());
        for (int i = 0; i < brands.size(); i++) {
            System.out.println((i + 1) + ". " + brands.get(i));
        }
        //For the user to choose the brand.
        System.out.print("\nEnter your choice (brand number): ");
        int brandChoice = sc.nextInt();
        String selectedBrand = brands.get(brandChoice - 1);

        // Fetch models for selected brand.
        HashMap<String, Double> models = carData.get(selectedBrand);
        List<String> modelList = new ArrayList<>(models.keySet());
        
        //data retrieval using HashMap
        System.out.println("\nModels available for " + selectedBrand + ":");
        for (int i = 0; i < modelList.size(); i++) {
            System.out.println((i + 1) + ". " + modelList.get(i) + " - $" + models.get(modelList.get(i)));
        }
        
        //User selects the model ,and shows ex-show room price.
        System.out.print("\nEnter model number: ");
        int modelChoice = sc.nextInt();
        String selectedModel = modelList.get(modelChoice - 1);
        double exShowroomPrice = models.get(selectedModel);

        // Ask for engine CC (for luxury tax cndts).
        System.out.print("\nEnter Engine CC (e.g., 6750): ");
        int engineCC = sc.nextInt();

        // This car inherits from vehicle ->Inheritance.
        // These fields are private ,access through getters -> encapsulation.
        // vehicle uses on-road price calculation, car defines how -> abstraction.
        // we call car methods,java decides what to run -> polymorphism.
        Car car = new Car(selectedBrand, selectedModel, exShowroomPrice, engineCC);

        // Asks if user wants the 5year third party insurance.
        System.out.print("\nDo you want to include 5-year Third Party Insurance? (yes/no): ");
        boolean includeThirdParty = sc.next().equalsIgnoreCase("yes");
        
        // Polymorphism
        // overriding ->car overrides vehicle here. here JVM decides according to object type.
        double onRoadPrice = car.calculateOnRoadPrice();
        // overloading ->compile decides which method to use.Based on insurance applies formulas.
        double insuranceCost = car.calculateInsurance(exShowroomPrice, includeThirdParty);
        double totalAmount = onRoadPrice + insuranceCost;

        // Display final summary similar to expected output format.
        System.out.println("\n--- BILLING SUMMARY ---");
        System.out.println("Brand: " + selectedBrand);
        System.out.println("Model: " + selectedModel);
        System.out.printf("Ex-Showroom Price: $%.2f\n", exShowroomPrice);
        System.out.printf("On-Road Price:     $%.2f\n", onRoadPrice);
        System.out.printf("Insurance:         $%.2f\n", insuranceCost);
        System.out.printf("Total Payable:     $%.2f\n", totalAmount);

        System.out.println("\nThank you for choosing Big Boy Toys!");
    }
}
