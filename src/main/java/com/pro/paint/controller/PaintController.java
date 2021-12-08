package com.pro.paint.controller;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pro.paint.model.*;
import com.pro.paint.model.Rectangle;
import com.pro.paint.model.Shape;
import com.pro.paint.model.factory.IShapeFacory;
import com.pro.paint.model.factory.ShapeFactory;
import com.pro.paint.service.PaintService;
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

    @GetMapping("/findShape")
    public Shape findShape(@RequestBody Point point) {
        return paintService.findShape(point);
    }



    @PostMapping("/addShape/circle")
    public Shape addShape(@RequestBody Circle shape) {
        return paintService.addShape(shape);
    }

    @PostMapping("/addShape/rectangle")
    public Shape addShape(@RequestBody Rectangle shape) {
        return paintService.addShape(shape);
    }

    @PostMapping("/addShape/ellipse")
    public Shape addShape(@RequestBody Ellipse shape) {
        return paintService.addShape(shape);
    }

    @PostMapping("/addShape/triangle")
    public Shape addShape(@RequestBody Triangle shape) {
        return paintService.addShape(shape);
    }

    @PostMapping("/addShape/lineSegment")
    public Shape addShape(@RequestBody LineSegment shape) {
        return paintService.addShape(shape);
    }

    @DeleteMapping("/deleteShape")
    public void deleteShape(@RequestBody Point point) {
        paintService.deleteShape(point);
    }

}
