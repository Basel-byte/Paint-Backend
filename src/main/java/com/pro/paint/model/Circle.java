package com.pro.paint.model;

import java.awt.*;

public class Circle extends Shape implements Cloneable{

    Point center;
    int r;

    public Circle() {
    }

    public Circle(String name, String color, String backgroundColor, Point center, int r) {
        super(name, color, backgroundColor);
        this.center = center;
        this.r = r;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public boolean isSelected(Point point) {
        return Math.pow(point.x - center.x, 2) + Math.pow(point.y - center.y, 2) <= Math.pow(r, 2);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Circle clonedCircle = null;
        try {
            clonedCircle = (Circle) super.clone();
            clonedCircle.setCenter((Point) this.getCenter().clone());
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clonedCircle;
    }
}
