package com.helius.dateAndTime;

import org.junit.Test;

import java.time.Instant;

/**
 * @Author Helius
 * @Create 2020-05-21-11:49 下午
 */
public class InstantTest {
    @Test
    public void test01() {
        Instant now = Instant.now();
        System.out.println("now = " + now);
        Instant instant = Instant.ofEpochSecond(60, 100000);
        System.out.println("instant = " + instant);
    }
}
