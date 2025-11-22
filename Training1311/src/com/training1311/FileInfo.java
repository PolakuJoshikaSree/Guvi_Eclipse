package com.training1311;

import java.io.*;

public class FileInfo {
    public static void main(String[] args) {
        int lines = 0;
        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
            String s;
            
            //reads one line at once
            while ((s = br.readLine()) != null) {
            	//we read it increments
                lines++;
                //converts everything to lowercase
                String t = s.toLowerCase();
                int i = 0;
                //returns here india starts and increments till 5 so india word will be read.
               
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
