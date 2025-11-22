package com.training1311;

import java.nio.file.*;
import java.util.stream.*;

public class FileInfoFP {
    public static void main(String[] args) {
        try {
        	//This reads the file as a stream of lines instead of using loops.
            long lines = Files.lines(Paths.get("sample.txt")).count();

            long indiaCount = Files.lines(Paths.get("sample.txt"))
            		//to lowercase so its easier to search
                    .map(String::toLowerCase)
                    //splits the streams of arrays
                    .flatMap(s -> Stream.of(s.split(" ")))
                    //filters the word india
                    .filter(w -> w.contains("india"))
                    //immediately returns how many lines there are.
                    .count();

            System.out.println("no of lines in file:" + lines);
            System.out.println("count of india word:" + indiaCount);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
