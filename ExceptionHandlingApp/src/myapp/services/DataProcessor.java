package myapp.services;

import myapp.exceptions.InvalidInputException;

public class DataProcessor {

    /**
     * Processes a string. Throws an InvalidInputException if the input is null or empty.
     * @param input The string to process.
     */
    public void processString(String input) {
        if (input == null || input.trim().isEmpty()) {
            // The `throw` keyword explicitly throws a new exception object
            throw new InvalidInputException("Input cannot be null or empty.");
        }
        // If validation passes, process the data
        System.out.println("Processing data: '" + input + "'");
    }
}
