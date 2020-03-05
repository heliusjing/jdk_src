package com.helius.atomtic;

public class Main {
    public static void main(String[] args){
        caclLength("XSUWHQ");
    }

    
    public static int caclLength(String str){
        String[] arr = str.split(" ");
        int length = arr[arr.length - 1].length();
        System.out.println("length = " + length);
        return length;
    }
}