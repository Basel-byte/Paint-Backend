package com.pro.paint.model;

import java.awt.*;

public abstract class Shape implements Cloneable{
    String name;
    String color;
    String backgroundColor;

    public Shape() {
    }

    public Shape(String name, String color, String backgroundColor) {
        this.name = name;
        this.color = color;
        this.backgroundColor = backgroundColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        Shape clonedShape = null;

        try {
            clonedShape = (Shape) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clonedShape;
    }

    public abstract boolean isSelected(Point point);

}