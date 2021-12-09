package com.pro.paint.model;

import java.awt.*;

public class Ellipse extends Shape implements Cloneable {

    Point center;
    int r1;
    int r2;

    public Ellipse() {
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

    public boolean isSelected(Point point) {
        double term1 = Math.pow(point.x - center.x, 2) / Math.pow(r1, 2);
        double term2 = Math.pow(point.y - center.y, 2) / Math.pow(r2, 2);

        return  term1 + term2 <= 1;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Ellipse clonedEllipse = null;
        try {
            clonedEllipse = (Ellipse) super.clone();
            clonedEllipse.setCenter((Point) this.getCenter().clone());
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clonedEllipse;
    }
}
