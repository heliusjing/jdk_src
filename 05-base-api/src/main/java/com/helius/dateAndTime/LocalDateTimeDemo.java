package com.helius.dateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 * @Author Helius
 * @Create 2020-04-06-2:04 下午
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MAY, 18, 13, 45, 20);
//        LocalDateTime.of()
        LocalDate date = LocalDate.of(2019, Month.MAY, 23);
        LocalDateTime localDateTime = date.atTime(13, 45, 20);
//        date.atTime(Time)


    }
}
