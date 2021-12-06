package com.pro.paint.service;

import com.pro.paint.model.Shape;

import java.awt.*;
import java.util.List;

public interface IService {

    public List<Shape> getAllShapes();

    public Shape findShape(Point point);

    public void addShape(Shape shape);

    public void deleteShape(Point point);
}
