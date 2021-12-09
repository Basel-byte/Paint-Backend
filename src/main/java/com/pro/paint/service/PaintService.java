package com.pro.paint.service;

import com.pro.paint.model.*;
import com.pro.paint.model.Rectangle;
import com.pro.paint.model.Shape;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

@Service
public class PaintService implements IService{

    public final Stack<List<Shape>> shapeStack;
    public final Stack<List<Shape>> tempStack;
    private int index;

    public PaintService() {
        shapeStack = new Stack<>();
        tempStack = new Stack<>();

    }

    public List<Shape> getAllShapes() {
        if (!shapeStack.isEmpty())
            return shapeStack.peek();
        return null;
    }

    public Shape findShape(Point point) {
        List<Shape> shapeList;
        if (shapeStack.isEmpty())
            return null;
        shapeList = shapeStack.peek();
        for (int i = shapeList.size() - 1; i >= 0; i--) {
            if (shapeList.get(i).isSelected(point)) {
                index = i;
                return shapeList.get(i);
            }
        }
        return null;
    }

    public void addShape(Shape shape) throws CloneNotSupportedException {
        List<Shape> anotherList = new ArrayList<>();
        if (!shapeStack.isEmpty())
            anotherList = createNewList(shapeStack.peek());
        anotherList.add(shape);
        shapeStack.push(anotherList);
    }

    public void deleteShape(Point point) throws CloneNotSupportedException {
        List<Shape> anotherList;
        if (shapeStack.isEmpty())
            return;
        anotherList = createNewList(shapeStack.peek());
        Shape shape = findShape(point);
        anotherList.remove(index);
        shapeStack.push(anotherList);
    }

    public void undo() {
        if (!shapeStack.isEmpty()) {
            List<Shape> tempList = shapeStack.pop();
            tempStack.push(tempList);
        }
    }

    public void redo() {
        if (!tempStack.isEmpty()) {
            List<Shape> tempList = tempStack.pop();
            shapeStack.push(tempList);
        }
    }

    public List<Shape> createNewList(List<Shape> shapeList) throws CloneNotSupportedException {
        List<Shape> shapeListClone = new ArrayList<>();

        Iterator<Shape> iterator = shapeList.iterator();

        while (iterator.hasNext()) {
            shapeListClone.add((Shape) iterator.next().clone());
        }
        return shapeListClone;
    }

}
