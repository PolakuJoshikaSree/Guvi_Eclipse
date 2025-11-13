package com.training1311;

import java.io.*;

public class FileInfo {
    public static void main(String[] args) {
        int lines = 0;
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
            String s;

            while ((s = br.readLine()) != null) {
                lines++;
                String t = s.toLowerCase();
                int i = 0;
                while ((i = t.indexOf("india", i)) != -1) {
                    count++;
                    i += 5;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("no of lines in file:" + lines);
        System.out.println("the word india in file:" + count);
    }
}
