package com.example.myapp;

import myapp.services.DataProcessor;
import myapp.exceptions.InvalidInputException;

public class Main {

    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();

        // --- Example 1: Valid input ---
        try {
            System.out.println("--- Attempting valid input ---");
            processor.processString("Hello, World!");
        } catch (InvalidInputException e) {
            System.err.println("Caught an exception: " + e.getMessage());
        }

        System.out.println("\n------------------------------\n");

        // --- Example 2: Invalid input ---
        try {
            System.out.println("--- Attempting invalid input ---");
            // The `processString` method will throw an exception here
            processor.processString(null); 
        } catch (InvalidInputException e) {
            // The program's flow is redirected to this catch block
            System.err.println("Caught an exception: " + e.getMessage());
        }
    }
}
