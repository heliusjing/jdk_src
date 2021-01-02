package com.heliius.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chengfei.jin
 */
public class Drawing implements Shape {

    private List<Shape> shapes = new ArrayList<>();

    @Override
    public void draw(String fillColor) {
        for (Shape sh : shapes) {
           sh.draw(fillColor);
        }
    }

    public void add(Shape shape) {
        this.shapes.add(shape);
    }

    public void remove(Shape shape) {
        shapes.remove(shape);
    }

    public void clear() {
        System.out.println("Clearing all the shapes");
        this.shapes.clear();
    }
}
