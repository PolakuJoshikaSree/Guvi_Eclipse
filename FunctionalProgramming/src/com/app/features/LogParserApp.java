package com.app.features;

import java.io.IOException;
import java.nio.file.*;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * LogParserApp
 * Parses and summarizes log files using Java Streams & Lambdas.
 *
 * Features:
 * Groups log lines by severity level (INFO/WARN/ERROR)
 * Counts occurrences using Collectors.groupingBy
 */
public class LogParserApp {

    public static void main(String[] args) throws IOException {
        Map<String, Long> logSummary = Files.lines(Paths.get("logs.txt"))
                .filter(line -> line.matches("^(INFO|WARN|ERROR).*"))
                .collect(Collectors.groupingBy(
                        line -> line.split(" - ")[0],
                        Collectors.counting()
                ));

        System.out.println("\n=== LOG SUMMARY REPORT ===");
        logSummary.forEach((level, count) -> System.out.println(level + " : " + count));
        System.out.println("===========================");
    }
}
