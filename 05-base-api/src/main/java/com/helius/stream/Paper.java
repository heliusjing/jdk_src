package com.helius.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Helius
 * @Create 2020-06-04-9:47 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paper implements Serializable {


    private static final long serialVersionUID = -6692788214714846672L;

    String studentName;
    String className;
    Integer score;
}
