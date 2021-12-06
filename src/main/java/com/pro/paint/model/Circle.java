package com.pro.paint.model;

import java.awt.*;

public class Circle extends Shape {

    Point center;
    int r;

    public Circle() {
    }

    public Circle(Circle target) {
        super(target);
        if (target != null) {
            this.center = target.center;
            this.r = target.r;
        }
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

    public Shape clone() {
         return new Circle(this);
    }
}
