package com.pro.paint.model;

import java.awt.*;

public class Rectangle extends Shape {

    Point corner;
    int l;
    int w;

    public Rectangle() {
    }

    public Rectangle(Rectangle target) {
        super(target);
        if (target != null) {
            this.corner = target.corner;
            this.l = target.l;
            this.w = target.w;
        }
    }

    public Rectangle(String name, String color, String backgroundColor, Point corner, int l, int w) {
        super(name, color, backgroundColor);
        this.corner = corner;
        this.l = l;
        this.w = w;
    }

    public Point getCorner() {
        return corner;
    }

    public void setCorner(Point corner) {
        this.corner = corner;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public boolean isSelected(Point point) {
        return point.x >= corner.x && point.x <= corner.x + l && point.y >= corner.y && point.y <= corner.y + w;
    }

    public Shape clone(){
        return new Rectangle(this);
    }
}
