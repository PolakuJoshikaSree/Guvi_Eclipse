package com.grade.service;

import java.util.*;
import com.grade.model.Student;

public class GradeService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students added yet!");
            return;
        }

        for (Student s : students) {
            System.out.println("\nStudent: " + s.getName());
            System.out.println("Grades: " + s.getSubjectGrades());
            System.out.printf("Average: %.2f%n", s.calculateAverage());
        }
    }

    public void searchStudent(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                System.out.println("\nStudent Found: " + s.getName());
                System.out.println("Grades: " + s.getSubjectGrades());
                System.out.printf("Average: %.2f%n", s.calculateAverage());
                return;
            }
        }
        System.out.println("Student not found!");
    }
}
