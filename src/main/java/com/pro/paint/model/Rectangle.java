package com.pro.paint.model;

import java.awt.*;

public class Rectangle extends Shape {

    Point corner;
    int l;
    int w;

    public Rectangle() {
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
        if (l > 0 && w > 0) {
            return point.x >= corner.x && point.x <= corner.x + w && point.y >= corner.y && point.y <= corner.y + l;
        }
        else if (l > 0 && w < 0 )
            return point.x <= corner.x && point.x >= corner.x + w && point.y >= corner.y && point.y <= corner.y + l;
        else if (l < 0 && w < 0)
            return point.x <= corner.x && point.x >= corner.x + w && point.y <= corner.y && point.y >= corner.y + l;
        return point.x >= corner.x && point.x <= corner.x + w && point.y <= corner.y && point.y >= corner.y + l;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Rectangle clonedRectangle = null;
        try {
            clonedRectangle = (Rectangle) super.clone();
            clonedRectangle.setCorner((Point) this.getCorner().clone());
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clonedRectangle;
    }
}
