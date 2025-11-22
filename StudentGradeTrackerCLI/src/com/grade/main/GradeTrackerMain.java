package com.grade.main;

import java.util.*;
import com.grade.model.Student;
import com.grade.service.GradeService;

public class GradeTrackerMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService service = new GradeService();
        while (true) {
            System.out.println("\n====== STUDENT GRADE TRACKER ======");
            System.out.println("1. Add Student and Grades");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(" Please enter a valid number!");
                continue;
            }
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter student name: ");
                    Student s = new Student(sc.nextLine());
                    System.out.print("Enter number of subjects: ");
                    int count = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter subject name: ");
                        String subject = sc.nextLine();
                        System.out.print("Enter grade: ");
                        int grade = Integer.parseInt(sc.nextLine());
                        s.addGrade(subject, grade);
                    }
                    service.addStudent(s);
                    System.out.println("Student added successfully!");
                }
                case 2 -> service.displayAllStudents();
                case 3 -> {
                    System.out.print("Enter student name to search: ");
                    String name = sc.nextLine();
                    service.searchStudent(name);
                }
                case 4 -> {
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println(" Invalid choice. Try again!");
            }
        }
    }
}
