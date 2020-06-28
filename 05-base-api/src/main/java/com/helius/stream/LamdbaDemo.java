package com.helius.stream;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Author Helius
 * @Create 2020-06-04-10:26 下午
 */
public class LamdbaDemo {
    @Test
    public void test02() {
        LocalDate jdk14 = LocalDate.of(2020, 3, 17);
        LocalDate nowDate = LocalDate.now();
        System.out.println("距离jdk14发布还有：" +
                nowDate.until(jdk14, ChronoUnit.DAYS) + "天");
        LocalDateTime now = LocalDateTime.now();
        Date toDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("LocalDateTime 转换成 Date:" + toDate);
        //

    }

    /**
     * 测试BigDecimal类
     */
    @Test
    public void test03() {

    }

    public static boolean compare(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        int bj = b1.compareTo(b2);
        boolean res;
        if (bj > 0) {
            res = true;
        } else {
            res = false;
        }
        return res;
    }

}
