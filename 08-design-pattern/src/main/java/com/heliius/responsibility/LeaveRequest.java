package com.heliius.responsibility;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author Helius
 * @Create 2020-02-26-18:09
 */
@Data
@AllArgsConstructor
public class LeaveRequest {
    private String name;    // 请假人姓名
    private int numOfDays;  // 请假天数
}
