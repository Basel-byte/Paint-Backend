package com.pro.paint.model;

import java.awt.*;

public class LineSegment extends Shape {

    Point start;
    Point end;

    public LineSegment() {
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

    public boolean isSelected(Point point) {
        double LHS = (double) (point.y - start.y) / (double) (point.x - start.x);
        double RHS = (double) (end.y - start.y) / (double) (end.x - start.x);
        return LHS == RHS;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        LineSegment clonedLineSegment = null;
        try {
            clonedLineSegment = (LineSegment) super.clone();
            clonedLineSegment.setStart((Point) this.getStart().clone());
            clonedLineSegment.setEnd((Point) this.getEnd().clone());
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clonedLineSegment;
    }
}
