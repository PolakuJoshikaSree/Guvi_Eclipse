package com.app.features;

import java.util.*;
import java.util.stream.Collectors;

/**
 * FunctionalRefactorDemo
 * Demonstrates refactoring of imperative code
 * into functional style using Streams and Lambdas.
 */
public class FunctionalRefactorDemo {

    public static void main(String[] args) {

        // Original Imperative Code
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        int sum = 0;
        for (int n : numbers) {
            if (n > 25) sum += n;
        }
        System.out.println("Imperative Sum >25: " + sum);

        // Refactored Functional Version
        int functionalSum = numbers.stream()
                .filter(n -> n > 25)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Functional Sum >25: " + functionalSum);

        // Functional Example with Strings
        List<String> names = Arrays.asList("joshika", "aashish", "teja", "kiran");
        List<String> sortedUpper = names.stream()
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted Uppercase Names: " + sortedUpper);
    }
}
