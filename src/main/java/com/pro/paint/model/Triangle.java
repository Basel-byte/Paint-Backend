package com.pro.paint.model;

import java.awt.*;

public class Triangle extends Shape {

    Point vertex1;
    Point vertex2;
    Point vertex3;

    public Triangle(){
    }

    public Triangle(Triangle target) {
        super(target);
        if (target != null) {
            this.vertex1 = target.vertex1;
            this.vertex2 = target.vertex2;
            this.vertex3 = target.vertex3;
        }
    }

    public Triangle(String name, String color, String backgroundColor, Point vertex1, Point vertex2, Point vertex3) {
        super(name, color, backgroundColor);
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.vertex3 = vertex3;
    }

    public Point getVertex1() {
        return vertex1;
    }

    public void setVertex1(Point vertex1) {
        this.vertex1 = vertex1;
    }

    public Point getVertex2() {
        return vertex2;
    }

    public void setVertex2(Point vertex2) {
        this.vertex2 = vertex2;
    }

    public Point getVertex3() {
        return vertex3;
    }

    public void setVertex3(Point vertex3) {
        this.vertex3 = vertex3;
    }

    public Shape clone() {
        return new Triangle(this);
    }
}
