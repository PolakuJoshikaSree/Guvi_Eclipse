package com.myhotel.booking;

import java.util.*;

public class HotelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of hotels: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        List<Hotel> hotels = new ArrayList<>();

        // Create hotels
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name for Hotel " + (i + 1) + ": ");
            String name = sc.nextLine();

            System.out.print("Enter total number of rooms in " + name + ": ");
            int rooms = sc.nextInt();
            sc.nextLine(); 

            hotels.add(new Hotel(name, rooms));
        }

        while (true) {
            System.out.print("\nDo you want to book a room? (yes/no): ");
            String choice = sc.next().toLowerCase();

            if (choice.equals("no")) {
                System.out.println("Booking process ended.");
                break;
            }

            System.out.println("\nAvailable hotels and rooms:");
            for (int i = 0; i < hotels.size(); i++) {
                System.out.print((i + 1) + ". ");
                hotels.get(i).displayInfo();
            }

            System.out.print("\nEnter hotel number to book (1-" + n + "): ");
            int hotelNum = sc.nextInt();

            if (hotelNum < 1 || hotelNum > n) {
                System.out.println("Invalid hotel number!");
                continue;
            }

            Hotel selectedHotel = hotels.get(hotelNum - 1);

            if (selectedHotel.bookRoom()) {
                System.out.println("✅ Room booked successfully at " + selectedHotel.name + "!");
            } else {
                System.out.println(" Sorry, " + selectedHotel.name + " is fully booked!");
            }
        }

        System.out.println("\nFinal Room Availability:");
        for (Hotel h : hotels) {
            h.displayInfo();
        }

        sc.close();
    }
}