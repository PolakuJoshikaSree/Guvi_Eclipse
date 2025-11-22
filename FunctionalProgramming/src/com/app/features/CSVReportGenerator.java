package com.app.features;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

/**
 * CSVReportGenerator
 * Reads data from sales.csv located in the project root folder.
 * Uses Java Streams for analytics and prints total revenue,
 * top selling category, and average product price.
 */
public class CSVReportGenerator {

    // Record to represent each sales entry
    record Sale(int id, String product, String category, int quantity, double price) {}

    public static void main(String[] args) {
        // Print working directory (to help confirm file location)
        System.out.println("Working directory: " + System.getProperty("user.dir"));

        try {
            Path csvPath = Paths.get("sales.csv");

            // Verify file presence
            if (!Files.exists(csvPath)) {
                throw new IOException("sales.csv not found in project folder!");
            }

            System.out.println("📂 Using: sales.csv");

            // Read CSV file as plain UTF-8 text
            List<String> rawLines = Files.readAllLines(csvPath, StandardCharsets.UTF_8);

            // Parse CSV data into Sale records
            List<Sale> sales = rawLines.stream()
                    .map(String::trim)
                    .filter(line -> !line.isEmpty() && !line.startsWith("id"))
                    .map(line -> line.split("[,;\\s]+"))  // allow commas or semicolons
                    .filter(data -> data.length >= 5)
                    .map(data -> {
                        try {
                            return new Sale(
                                    Integer.parseInt(data[0].trim()),
                                    data[1].trim(),
                                    data[2].trim(),
                                    Integer.parseInt(data[3].trim()),
                                    Double.parseDouble(data[4].trim())
                            );
                        } catch (NumberFormatException e) {
                            return null; // skip malformed lines
                        }
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            if (sales.isEmpty()) {
                throw new IOException("No valid data rows found in sales.csv.");
            }

            //  Analytics
            double totalRevenue = sales.stream()
                    .mapToDouble(s -> s.quantity * s.price)
                    .sum();

            String topCategory = sales.stream()
                    .collect(Collectors.groupingBy(
                            Sale::category,
                            Collectors.summingDouble(s -> s.quantity * s.price)
                    ))
                    .entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse("N/A");

            double avgPrice = sales.stream()
                    .mapToDouble(Sale::price)
                    .average()
                    .orElse(0);

            // Report Output
            System.out.println("\n=== SALES ANALYTICS REPORT ===");
            System.out.println("Total Revenue        : ₹" + totalRevenue);
            System.out.println("Top Selling Category : " + topCategory);
            System.out.println("Average Product Price: ₹" + avgPrice);
            System.out.println("===============================");

        } catch (IOException e) {
            System.err.println("⚠️ Error reading or parsing file: " + e.getMessage());
        }
    }
}
