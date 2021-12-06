package com.pro.paint.service;

import com.pro.paint.model.*;
import com.pro.paint.model.Shape;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@Service
public class PaintService implements IService{

    private List<Shape> shapes;
    private Stack<List<Shape>> shapeStack;

    public PaintService() {
        shapes = new ArrayList<>();
        shapeStack = new Stack<>();
        shapeStack.push(shapes);
    }

    public List<Shape> getAllShapes() {
        return shapeStack.peek();
    }

    public Shape findShape(Point point) {
        List<Shape> tempList = shapeStack.peek();
        Circle circle = (Circle) tempList.get(0).;

    }

    public void addShape(Shape shape) {
        List<Shape> anotherList = shapeStack.peek();
        anotherList.add(shape);
        shapeStack.push(anotherList);
    }

    public void deleteShape(Point point) {
//        List<Shape> anotherList = shapeStack.peek();
//        for (int i = anotherList.size() - 1; i >= 0; i--) {
//            if (shape.equals(anotherList.get(i))) {
//                anotherList.remove(i);
//                break;
//            }
//        }
//        shapeStack.push(anotherList);
    }

}
