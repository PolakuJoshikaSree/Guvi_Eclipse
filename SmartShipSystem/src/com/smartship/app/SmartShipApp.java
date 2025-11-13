package com.smartship.app;

import com.smartship.core.*;
import com.smartship.exceptions.*;
import com.smartship.utils.LoggerUtil;
import java.util.Scanner;

public class SmartShipApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DeliveryManager manager = new DeliveryManager();

        LoggerUtil.log("=== Welcome to SmartShip Delivery Management System ===");

        try {
            manager.addAgent(new DeliveryAgent("A1", "Delhi", 3));
            manager.addAgent(new DeliveryAgent("A2", "Mumbai", 2));
            manager.addAgent(new DeliveryAgent("A3", "Delhi", 2));

            // Sample routes
            manager.addRoute(new Route("Warehouse", "Delhi", 50));
            manager.addRoute(new Route("Warehouse", "Mumbai", 120));
        } catch (DuplicateEntryException | RouteUnavailableException e) {
            LoggerUtil.error("Setup Error: " + e.getMessage());
        }

        try {
            System.out.print("Enter Package ID: ");
            String packageId = sc.nextLine();

            System.out.print("Enter Destination City: ");
            String city = sc.nextLine();

            System.out.print("Enter Priority (1-10): ");
            int priority = sc.nextInt();

            System.out.print("Enter Weight: ");
            double weight = sc.nextDouble();

            DeliveryPackage pkg = new DeliveryPackage(packageId, city, priority, weight);

            manager.assignPackageToAgent(pkg);
            LoggerUtil.log("Package " + packageId + " assigned successfully!");

        } catch (InvalidPackageException | AgentNotAvailableException | OverloadException e) {
            LoggerUtil.error(e.getMessage());
        }
        LoggerUtil.log("Thank you for using SmartShip!");
    }
}