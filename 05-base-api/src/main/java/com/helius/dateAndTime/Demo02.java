package com.helius.dateAndTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @Author Helius
 * @Create 2020-04-05-11:25 下午
 */
public class Demo02 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 11, 11, 8, 54, 38);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
        //更改时区
        ZonedDateTime zonedDateTime1 = zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));





    }
}
