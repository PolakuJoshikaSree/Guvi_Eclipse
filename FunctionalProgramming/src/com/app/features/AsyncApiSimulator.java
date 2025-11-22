package com.app.features;

import java.util.concurrent.*;

/**
 * AsyncApiSimulator
 * Demonstrates asynchronous execution using CompletableFuture.
 *
 * Features:
 * Simulates multiple concurrent API calls
 * Uses CompletableFuture for non-blocking async flow
 * Waits for all tasks to complete using allOf()
 *Ideal for understanding parallelism and async programming.
 */
public class AsyncApiSimulator {

    // Simulate an API call
    public static CompletableFuture<String> fetchDataFromAPI(String endpoint) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Connecting to " + endpoint + "...");
                Thread.sleep(1200); // simulate network delay
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return " Response received from " + endpoint;
        });
    }

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> api1 = fetchDataFromAPI("https://api/products");
        CompletableFuture<String> api2 = fetchDataFromAPI("https://api/users");
        CompletableFuture<String> api3 = fetchDataFromAPI("https://api/orders");

        CompletableFuture<Void> allApis = CompletableFuture.allOf(api1, api2, api3);
        allApis.join();

        System.out.println("\n=== ASYNC API RESPONSES ===");
        System.out.println(api1.get());
        System.out.println(api2.get());
        System.out.println(api3.get());
        System.out.println("All API requests completed successfully!");
    }
}
