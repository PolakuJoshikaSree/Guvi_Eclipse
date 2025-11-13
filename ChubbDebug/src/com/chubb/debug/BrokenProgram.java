package com.chubb.debug;

public class BrokenProgram {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        for(int i=0; i<=arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
/*for(int i=0; i < arr.length; i++) {
    System.out.println(arr[i]);
}*/

