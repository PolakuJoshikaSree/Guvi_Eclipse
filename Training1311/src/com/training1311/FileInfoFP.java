package com.training1311;

import java.nio.file.*;
import java.util.stream.*;

public class FileInfoFP {
    public static void main(String[] args) {
        try {
            long lines = Files.lines(Paths.get("sample.txt")).count();

            long indiaCount = Files.lines(Paths.get("sample.txt"))
                    .map(String::toLowerCase)
                    .flatMap(s -> Stream.of(s.split(" ")))
                    .filter(w -> w.contains("india"))
                    .count();

            System.out.println("no of lines in file:" + lines);
            System.out.println("count of india word:" + indiaCount);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
