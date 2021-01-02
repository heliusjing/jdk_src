package com.helius.character7;

import java.util.List;
import java.util.Vector;

/**
 * @Author Helius
 * @Create 2020-08-18-9:56 下午
 */
public class TraceStudent {
    static List<WebPage> webpages = new Vector<>();

    public static void createWebPage() {
        for (int i = 0; i < 100; i++) {
            WebPage wp = new WebPage();
            wp.setUrl("http://www." + Integer.toString(i) + ".com");
            wp.setContent(Integer.toString(i));
            webpages.add(wp);
        }
    }

    public static void main(String[] args) {
        createWebPage();
        Student st3 = new Student(3,"billy");
        Student st5 = new Student(5,"alice");
        Student st7 = new Student(7,"taotao");
        for (int i = 0; i < webpages.size(); i++) {
            if (i % st3.getId() == 0) {
                st3.getHistory().add(webpages.get(i));
            }
            if (i % st5.getId() == 0) {
                st5.getHistory().add(webpages.get(i));
            }
            if (i % st7.getId() == 0) {
                st7.getHistory().add(webpages.get(i));
            }
        }
        webpages.clear();
        System.gc();
    }
}
