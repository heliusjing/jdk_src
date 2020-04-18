package com.helius.dateAndTime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.Set;

/**
 * @Author Helius
 * @Create 2020-04-05-11:11 下午
 */
public class Java8TimeClassMethodDemo1 {
    public static void main(String[] args) {
        //使用now方法创建Instant的实例对象
        Instant instantNow = Instant.now();
        System.out.println(instantNow);
        //localDate、localDateTime、localTime
        Year year = Year.now();
        System.out.println(year);
        LocalDate localDate = LocalDate.of(2018, 8, 8);
        System.out.println(localDate);
        //获取所有的时区信息
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String availableZoneId : availableZoneIds) {
            System.out.println(availableZoneId);
        }
        ZoneId zoneId = ZoneId.systemDefault();












    }
}
