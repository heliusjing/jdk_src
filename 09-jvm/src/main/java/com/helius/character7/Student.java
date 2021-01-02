package com.helius.character7;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Vector;

/**
 * @Author Helius
 * @Create 2020-08-18-9:55 下午
 */
@Getter
@Setter
public class Student {
    private int id;
    private String name;
    private List<WebPage> history = new Vector<>();

    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

}
