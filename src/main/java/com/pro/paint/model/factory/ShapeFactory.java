package com.pro.paint.model.factory;

import com.pro.paint.model.*;

public class ShapeFactory implements IShapeFacory {

    @Override
    public Shape createShape(String name) {

        switch (name) {
            case "rectangle":
                return new Rectangle();
            case "circle":
                return new Circle();
            case "ellipse":
                return new Ellipse();
            case "triangle":
            case "rightTri":
                return new Triangle();
            case "line":
                return new LineSegment();
            default:
                return null;
        }
    }
}
