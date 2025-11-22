package com.app.hdfc.service;

import java.time.*;
import java.util.stream.*;

public class WeekendFinder {

    public void printWeekends(int year, Month month) {
        System.out.println("Weekend Dates in " + month + " " + year + ":");

        Stream.iterate(LocalDate.of(year, month, 1), date -> date.plusDays(1))
                .limit(month.length(Year.isLeap(year)))
                .filter(date -> date.getDayOfWeek() == DayOfWeek.SATURDAY
                        || date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .forEach(System.out::println);
    }
}
