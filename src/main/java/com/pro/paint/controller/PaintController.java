package com.pro.paint.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pro.paint.model.*;
import com.pro.paint.model.Rectangle;
import com.pro.paint.model.Shape;
import com.pro.paint.service.IService;
import com.pro.paint.service.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/paint")
public class PaintController {

    private IService paintService;
    @Autowired
    public PaintController(IService paintService) {
        this.paintService = paintService;
    }

    @GetMapping("/allShapes")
    public List<Shape> getAllShapes() {
        return paintService.getAllShapes();
    }

    @PostMapping("/addShape")
    public void addShape(@RequestBody String shapeStr) throws JsonProcessingException, CloneNotSupportedException {
        String str = shapeStr.replaceAll(" ", "");
//        System.out.println(str);
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

    @GetMapping("/undo")
    public void undo() {
        paintService.undo();
    }

    @GetMapping("/redo")
    public void redo() {
        paintService.redo();
    }

    @GetMapping("/saveAs/JSON")
    public void saveAsJSON() throws IOException, CloneNotSupportedException {
        paintService.saveAsJSON();
    }

    @GetMapping("/save")
    public void save() throws FileNotFoundException, CloneNotSupportedException {
        paintService.save();
    }

    @GetMapping("/open")
    public void openJSONFile() throws FileNotFoundException {
        paintService.openJSONFile();
    }


}
