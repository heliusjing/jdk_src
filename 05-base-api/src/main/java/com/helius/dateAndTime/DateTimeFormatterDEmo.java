package com.helius.dateAndTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author Helius
 * @Create 2020-04-06-1:15 下午
 */
public class DateTimeFormatterDEmo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        String s1 = now.format(DateTimeFormatter.ISO_DATE_TIME);
        String s2 = now.format(DateTimeFormatter.ISO_DATE);
        System.out.println(now);
        System.out.println(s1);
        System.out.println(s2);
//        System.out.println();


    }
}
