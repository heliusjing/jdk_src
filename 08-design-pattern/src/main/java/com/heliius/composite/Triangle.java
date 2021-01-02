package com.heliius.composite;

/**
 * @Author chengfei.jin
 */
public class Triangle implements Shape {

    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Triangle with color" + fillColor);
    }
}
