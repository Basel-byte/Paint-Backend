package com.pro.paint.model;

import java.awt.*;

public class LineSegment extends Shape {

    Point start;
    Point end;

    public LineSegment() {
    }

    public LineSegment(LineSegment target) {
        super(target);
        if (target != null) {
            this.start = target.start;
            this.end = target.end;
        }
    }

    public LineSegment(String name, String color, String backgroundColor, Point start, Point end) {
        super(name, color, backgroundColor);
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public Shape clone() {
        return new LineSegment(this);
    }
}
