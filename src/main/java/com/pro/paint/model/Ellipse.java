package com.pro.paint.model;

import java.awt.*;

public class Ellipse extends Shape {

    Point center;
    int r1;
    int r2;

    public Ellipse() {
    }

    public Ellipse(Ellipse target) {
        super(target);
        if (target != null) {
            this.center = target.center;
            this.r1 = target.r1;
            this.r2 = target.r2;
        }
    }

    public Ellipse(String name, String color, String backgroundColor, Point center, int r1, int r2) {
        super(name, color, backgroundColor);
        this.center = center;
        this.r1 = r1;
        this.r2 = r2;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getR1() {
        return r1;
    }

    public void setR1(int r1) {
        this.r1 = r1;
    }

    public int getR2() {
        return r2;
    }

    public void setR2(int r2) {
        this.r2 = r2;
    }

    public Shape clone() {
        return new Ellipse(this);
    }
}
