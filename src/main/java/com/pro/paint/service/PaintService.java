package com.pro.paint.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pro.paint.model.*;
import com.pro.paint.model.Rectangle;
import com.pro.paint.model.Shape;
import org.springframework.stereotype.Service;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

@Service
public class PaintService implements IService{

    public final Stack<List<Shape>> shapeStack;
    public final Stack<List<Shape>> tempStack;
    private final String JSONfilePath = "C:\\Users\\Dell\\IdeaProjects\\paint\\src\\main\\resources\\data.json";
    private final String XMLFilePath = "C:\\Users\\Dell\\IdeaProjects\\paint\\src\\main\\resources\\file.xml";
    private int index;
    private static String saveType;

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
        tempStack.clear();
        List<Shape> anotherList = new ArrayList<>();
        if (!shapeStack.isEmpty())
            anotherList = createNewList(shapeStack.peek());
        anotherList.add(shape);
        shapeStack.push(anotherList);
    }

    public void deleteShape(Point point) throws CloneNotSupportedException {
        tempStack.clear();
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
            if(shapeStack.size() == 1 && shapeStack.peek().size() > 1)
                return;
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

    public void saveAsJSON() throws IOException, CloneNotSupportedException {
        saveType = "JSON";
        Writer writer = new FileWriter(JSONfilePath);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Shape> shapes = createNewList(shapeStack.peek());
        gson.toJson(shapes, writer);
        writer.close();
        shapeStack.clear();
        tempStack.clear();
        shapeStack.push(shapes);
    }


    public void save() throws FileNotFoundException, CloneNotSupportedException {
        if (Objects.equals(saveType, "JSON")) {
            PrintWriter writer = new PrintWriter(JSONfilePath);
            List<Shape> shapes = createNewList(shapeStack.peek());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.print("");
            gson.toJson(shapes, writer);
            writer.close();
            shapeStack.clear();
            tempStack.clear();
            shapeStack.push(shapes);
        }
    }

    public void openJSONFile() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Map<String, Object>> shapeListMap = gson.fromJson(new FileReader(JSONfilePath), List.class);
        List<Shape> deserializedShapesList = new ArrayList<>();
        for (int i = 0; i < shapeListMap.size(); i++) {
            String name = (String) shapeListMap.get(i).get("name");
            String color = (String) shapeListMap.get(i).get("color");
            String backgroundColor = (String) shapeListMap.get(i).get("backgroundColor");
            switch (name) {
                case "circle":
                    int r =  ((Double) shapeListMap.get(i).get("r")).intValue();
                    int pointX = ((Double) ((Map<String, Object>)shapeListMap.get(i).get("center")).get("x")).intValue();
                    int pointY = ((Double) ((Map<String, Object>)shapeListMap.get(i).get("center")).get("y")).intValue();
                    Circle circle = new Circle(name, color, backgroundColor, new Point(pointX, pointY), r);
                    deserializedShapesList.add(circle);
                    break;
                case "ellipse":
                    int r1 = ((Double)shapeListMap.get(i).get("r1")).intValue();
                    int r2 = ((Double)shapeListMap.get(i).get("r2")).intValue();
                    pointX = ((Double)((Map<String, Object>)shapeListMap.get(i).get("center")).get("x")).intValue();
                    pointY = ((Double)((Map<String, Object>)shapeListMap.get(i).get("center")).get("y")).intValue();
                    Ellipse ellipse = new Ellipse(name, color, backgroundColor, new Point(pointX, pointY), r1, r2);
                    deserializedShapesList.add(ellipse);
                    break;
                case "rectangle":
                    int l = ((Double) shapeListMap.get(i).get("l")).intValue();
                    int w = ((Double) shapeListMap.get(i).get("w")).intValue();
                    pointX = ((Double) ((Map<String, Object>)shapeListMap.get(i).get("corner")).get("x")).intValue();
                    pointY = ((Double) ((Map<String, Object>)shapeListMap.get(i).get("corner")).get("y")).intValue();
                    Rectangle rectangle = new Rectangle(name, color, backgroundColor, new Point(pointX, pointY), l, w);
                    deserializedShapesList.add(rectangle);
                    break;
                case "triangle":
                    int v1_x = ((Double)((Map<String, Object>)shapeListMap.get(i).get("v1")).get("x")).intValue();
                    int v1_y = ((Double) ((Map<String, Object>)shapeListMap.get(i).get("v1")).get("y")).intValue();
                    Point v1 = new Point(v1_x, v1_y);
                    int v2_x = ((Double) ((Map<String, Object>)shapeListMap.get(i).get("v2")).get("x")).intValue();
                    int v2_y = ((Double) ((Map<String, Object>)shapeListMap.get(i).get("v2")).get("y")).intValue();
                    Point v2 = new Point(v2_x, v2_y);
                    int v3_x = ((Double) ((Map<String, Object>)shapeListMap.get(i).get("v3")).get("x")).intValue();
                    int v3_y = ((Double) ((Map<String, Object>)shapeListMap.get(i).get("v3")).get("y")).intValue();
                    Point v3 = new Point(v3_x, v3_y);
                    Triangle triangle = new Triangle(name, color, backgroundColor, v1, v2, v3);
                    deserializedShapesList.add(triangle);
                    break;
                case "line":
                    int start_x = ((Double) ((Map<String, Object>)shapeListMap.get(i).get("start")).get("x")).intValue();
                    int start_y = ((Double) ((Map<String, Object>)shapeListMap.get(i).get("start")).get("y")).intValue();
                    Point start = new Point(start_x, start_y);
                    int end_x = ((Double) ((Map<String, Object>)shapeListMap.get(i).get("end")).get("x")).intValue();
                    int end_y = ((Double) ((Map<String, Object>)shapeListMap.get(i).get("end")).get("y")).intValue();
                    Point end = new Point(end_x, end_y);
                    LineSegment lineSegment = new LineSegment(name, color, backgroundColor, start, end);
                    deserializedShapesList.add(lineSegment);
                    break;
                default:
                    break;
            }
        }
        shapeStack.push(deserializedShapesList);
    }

}
