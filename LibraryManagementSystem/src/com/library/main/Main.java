package com.library.main;

import java.util.Scanner;
import com.library.model.*;
import com.library.service.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryService lib = new LibraryService();
        System.out.println("📚 Welcome to the Library Management System 📚");
        while (true) {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. List All Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    lib.addBook(new Book(id, title, author));
                    System.out.println("Book added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter Member ID: ");
                    String mid = sc.nextLine();
                    System.out.print("Enter Member Name: ");
                    String name = sc.nextLine();
                    lib.addMember(new Member(mid, name));
                    System.out.println(" Member added successfully!");
                }
                case 3 -> {
                    System.out.print("Enter Book ID to borrow: ");
                    String bid = sc.nextLine();
                    System.out.print("Enter Member ID: ");
                    String memId = sc.nextLine();
                    lib.borrowBook(bid, memId);
                }
                case 4 -> {
                    System.out.print("Enter Book ID to return: ");
                    String bid = sc.nextLine();
                    lib.returnBook(bid);
                }
                case 5 -> lib.listBooks();
                case 6 -> {
                    System.out.println(" Exiting Library System. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println(" Invalid choice! Try again.");
            }
        }
    }
}
