package com.pro.paint.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pro.paint.model.*;
import com.pro.paint.model.Rectangle;
import com.pro.paint.model.Shape;
import com.pro.paint.model.factory.IShapeFacory;
import com.pro.paint.model.factory.ShapeFactory;
import com.pro.paint.service.PaintService;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;
import java.util.Objects;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/paint")
public class PaintController {

    private PaintService paintService;
    @Autowired
    public PaintController(PaintService paintService) {
        this.paintService = paintService;
    }

    @GetMapping("/allShapes")
    public List<Shape> getAllShapes() {
        return paintService.getAllShapes();
    }

    @PostMapping("/addShape")
    public void addShape(@RequestBody String shapeStr) throws JsonProcessingException, CloneNotSupportedException {
        String str = shapeStr.replaceAll(" ", "");
        System.out.println(str);
        switch (str.charAt(9)) {
            case 't':
                Triangle shape1 = new ObjectMapper().readValue(shapeStr, Triangle.class);
                paintService.addShape(shape1);
                break;
            case 'r':
                if (str.charAt(10) == 'i') {
                    Triangle shape2 = new ObjectMapper().readValue(shapeStr, Triangle.class);
                    paintService.addShape(shape2);
                }
                else {
                    Rectangle shape3 = new ObjectMapper().readValue(shapeStr, Rectangle.class);
                    paintService.addShape(shape3);
                }
                break;
            case 'c':
                Circle shape4 = new ObjectMapper().readValue(shapeStr, Circle.class);
                paintService.addShape(shape4);
                break;
            case 'e':
                Ellipse shape5 = new ObjectMapper().readValue(shapeStr, Ellipse.class);
                paintService.addShape(shape5);
                break;
            case 'l':
                LineSegment shape6 = new ObjectMapper().readValue(shapeStr, LineSegment.class);
                paintService.addShape(shape6);
                break;
            default:
                break;
        }
    }

    @PostMapping("/findShape")
    public Shape findShape(@RequestBody String pointStr) throws JsonProcessingException {
        Point point = new ObjectMapper().readValue(pointStr, Point.class);
        return paintService.findShape(point);
    }

    @PostMapping("/deleteShape")
    public void deleteShape(@RequestBody String pointStr) throws CloneNotSupportedException, JsonProcessingException {
        Point point = new ObjectMapper().readValue(pointStr, Point.class);
        paintService.deleteShape(point);
    }

    @PostMapping("/undo")
    public void undo() {
        paintService.undo();
    }

    @PostMapping("/redo")
    public void redo() {
        paintService.redo();
    }

}
