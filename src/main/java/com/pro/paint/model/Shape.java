package com.pro.paint.model;

import java.awt.*;

public abstract class Shape {
    String name;
    String color;
    String backgroundColor;

    public Shape() {
    }

    public Shape(Shape target) {
        if (target != null) {
            this.name = target.name;
            this.color = target.color;
            this.backgroundColor = target.backgroundColor;
        }
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

    public abstract boolean isSelected(Point point);

    public abstract Shape clone();
}