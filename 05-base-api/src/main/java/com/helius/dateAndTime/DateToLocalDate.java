package com.helius.dateAndTime;

import java.time.LocalDate;
import java.util.Date;

/**
 * @Author Helius
 * @Create 2020-04-06-12:57 下午
 */
public class DateToLocalDate {
    public static void main(String[] args) {
//        Date date = new Date();
//        Instant instant = date.toInstant();
//        //Date类包含日期和时间信息，但没时区信息
//        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
//        LocalDate localDate = zonedDateTime.toLocalDate();
//        System.out.println(date);
//        System.out.println(localDate);
/*        Date date = new Date(System.currentTimeMillis());
        LocalDate localDate = date.toLocalDate();
        System.out.println(date);
        System.out.println(localDate);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        System.out.println(timestamp);
        System.out.println(localDateTime);*/
        Date d = new Date();
        java.sql.Date date = new java.sql.Date(d.getTime());
        LocalDate localDate = date.toLocalDate();



    }
}
