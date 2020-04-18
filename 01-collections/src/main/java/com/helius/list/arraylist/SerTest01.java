package com.helius.list.arraylist;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @Author Helius
 * @Create 2020-04-11-11:08 下午
 */
public class SerTest01 {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("马云", 51);
        Student s2 = new Student("王键林", 45);
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stu.txt"));
        oos.writeObject(list);
        oos.close();
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stu.txt"));
        ArrayList<Student> list1 = (ArrayList<Student>) ois.readObject();
        for (Student student : list1) {
            System.out.println("student = " + student);
        }




    }
}
