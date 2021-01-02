package com.helius.bio;

import java.io.*;

/**
 * @Author Helius
 * @Create 2020-06-30-10:53 下午
 */
public class KeyBoard {
/*    public static void main(String[] args) {
        BufferedReader buf = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String str = null;

        System.out.println("请输入内容");
        try {
            str = buf.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("你输入的内容是：" + str);
    }*/

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/liuluming/Documents/hello.txt");
        // 此刻直接输出到屏幕
        System.out.println("hello");
        try {
            System.setOut(new PrintStream(new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("这些内容在文件中才能看到哦！");
    }


}
