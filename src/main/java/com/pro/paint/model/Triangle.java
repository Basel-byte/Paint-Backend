package com.pro.paint.model;

import java.awt.*;

public class Triangle extends Shape {

    Point v1;
    Point v2;
    Point v3;

    public Triangle(){
    }

    public Triangle(Triangle target) {
        super(target);
        if (target != null) {
            this.v1 = target.v1;
            this.v2 = target.v2;
            this.v3 = target.v3;
        }
    }

    public Triangle(String name, String color, String backgroundColor, Point v1, Point v2, Point v3) {
        super(name, color, backgroundColor);
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public Point getV1() {
        return v1;
    }

    public void setV1(Point v1) {
        this.v1 = v1;
    }

    public Point getV2() {
        return v2;
    }

    public void setV2(Point v2) {
        this.v2 = v2;
    }

    public Point getV3() {
        return v3;
    }

    public void setV3(Point v3) {
        this.v3 = v3;
    }

    public double area() {
        return Math.abs((v1.x * (v2.y - v3.y) + v2.x * (v3.y - v1.y) + v3.x * (v1.y - v2.y))/2.0);
    }

    public double area(Point p1, Point p2, Point p3) {
        return Math.abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y))/2.0);
    }

    public boolean isSelected(Point point) {
        double A = area();
        double A1 = area(point, v2, v3);
        double A2 = area(v1, point, v3);
        double A3 = area(v1, v2, point);

        return A == A1 + A2 + A3;
    }

    public Shape clone() {
        return new Triangle(this);
    }
}
