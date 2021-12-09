package com.pro.paint.service;

import com.pro.paint.model.Shape;

import java.awt.*;
import java.util.List;

public interface IService {

    public List<Shape> getAllShapes();

    public Shape findShape(Point point);

    public void addShape(Shape shape) throws CloneNotSupportedException;

    public void deleteShape(Point point) throws CloneNotSupportedException;

    public void undo();

    public void redo();
}
