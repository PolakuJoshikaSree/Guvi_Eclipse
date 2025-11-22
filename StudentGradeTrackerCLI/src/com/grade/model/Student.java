package com.grade.model;

import java.util.*;

public class Student extends Person {
    private Map<String, Integer> subjectGrades = new HashMap<>();

    public Student(String name) {
        super(name);
    }

    public void addGrade(String subject, int grade) {
        subjectGrades.put(subject, grade);
    }

    public double calculateAverage() {
        return subjectGrades.values().stream().mapToInt(i -> i).average().orElse(0.0);
    }

    public Map<String, Integer> getSubjectGrades() {
        return subjectGrades;
    }
}
