package com.helius.list.arraylist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author Helius
 * @Create 2020-04-11-11:04
 * java中的深拷贝和浅拷贝问题
 * 都没什么技术含量
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable,Cloneable {
    private String name;
    private Integer age;

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
        Student stu = (Student) super.clone();
        return stu;
    }


}
