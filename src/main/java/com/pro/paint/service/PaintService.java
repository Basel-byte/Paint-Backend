package com.pro.paint.service;

import com.pro.paint.model.*;
import com.pro.paint.model.Rectangle;
import com.pro.paint.model.Shape;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
public class PaintService implements IService{

    public final Stack<List<Shape>> shapeStack;

    public PaintService() {
        shapeStack = new Stack<>();
//        addShape(new Circle("circle", "red", "blue", new Point(1, 2), 2));
//        addShape(new Ellipse("ellipse", "yellow", "green", new Point(3, 4), 8, 6));
//        addShape(new LineSegment("line segment", "purple", "green", new Point(0, 0), new Point(10, 10)));
//        addShape(new Triangle("triangle", "blue", "black", new Point(0, 2), new Point(-4,  0), new Point(4, 0)));
//        addShape(new Rectangle("rectangle", "rose", "skyblue", new Point(0, 0), 3, 2));
    }

    public List<Shape> getAllShapes() {
        if (!shapeStack.peek().isEmpty())
            return shapeStack.peek();
        return null;
    }

    public Shape findShape(Point point) {
        List<Shape> shapeList;
        if (shapeStack.isEmpty())
            return null;
        shapeList = shapeStack.peek();
        for (int i = shapeList.size() - 1; i >= 0; i--) {
            if (shapeList.get(i).isSelected(point))
                return shapeList.get(i);
        }
        return null;
    }

    public Shape addShape(Shape shape) {
        List<Shape> anotherList = new ArrayList<>();
        if (!shapeStack.isEmpty())
            anotherList = shapeStack.peek();
        anotherList.add(shape);
        shapeStack.push(anotherList);
        return shape;
    }

    public void deleteShape(Point point) {
        List<Shape> anotherList;
        if (shapeStack.isEmpty())
            return;
        anotherList = shapeStack.peek();
        Shape shape = findShape(point);
        anotherList.remove(shape);
        shapeStack.push(anotherList);
    }


}
