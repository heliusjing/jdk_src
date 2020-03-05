package com.helius.structure.huawei;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i = 0; i<= n; i++){
            int temp = i*i;
            //判断尾数相等
            int length = String.valueOf(i).length();
            String str = String.valueOf(temp);
            //判断位数的问题
            String sub = str.substring(str.length()-length,str.length());
            if(String.valueOf(i).equals(sub)){
                count++;
                System.out.println(i);
            }
        }
        System.out.println(count);
    }
}
