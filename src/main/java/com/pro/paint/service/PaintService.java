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

    private final Stack<List<Shape>> shapeStack;

    public PaintService() {
        shapeStack = new Stack<>();
    }

    public List<Shape> getAllShapes() {
        return shapeStack.peek();
    }

    public Shape findShape(Point point) {
        List<Shape> shapeList = shapeStack.peek();
        for (int i = shapeList.size() - 1; i >= 0; i--) {
            if (shapeList.get(i).isSelected(point))
                return shapeList.get(i);
        }
        return null;
    }

    public void addShape(Shape shape) {
        List<Shape> anotherList = shapeStack.peek();
        anotherList.add(shape);
        shapeStack.push(anotherList);
    }

    public void deleteShape(Point point) {
        List<Shape> anotherList = shapeStack.peek();
        Shape shape = findShape(point);
        anotherList.remove(shape);
        shapeStack.push(anotherList);
    }

}
