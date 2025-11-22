package com.app.hdfc.main;

import com.app.hdfc.model.Employee;
import com.app.hdfc.service.HDFCBankService;
import com.app.hdfc.service.WeekendFinder;

import java.time.Month;
import java.util.*;

public class HDFCApp {
    public static void main(String[] args) {

        // Employees list
        List<Employee> employees = Arrays.asList(
                new Employee("Aashish", "HDFC", 10000),
                new Employee("Tanmay", "ICICI", 12000),
                new Employee("Soham", "HDFC", 15000),
                new Employee("Ashutosh", "SBI", 18000),
                new Employee("Chirag", "HDFC", 9000)
        );

        // Service to calculate total HDFC amount
        HDFCBankService service = new HDFCBankService();
        double total = service.getTotalAmountPaidByHDFC(employees);
        System.out.println("Total Amount Paid by HDFC Bank: " + total);

        // Find all Saturdays and Sundays in November
        WeekendFinder weekendFinder = new WeekendFinder();
        weekendFinder.printWeekends(2025, Month.NOVEMBER);
    }
}
