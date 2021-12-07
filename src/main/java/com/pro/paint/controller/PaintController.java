package com.pro.paint.controller;


import com.pro.paint.model.Circle;
import com.pro.paint.model.Shape;
import com.pro.paint.service.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/paint")
public class PaintController {

    PaintService paintService;

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

    @PostMapping("/addShape")
    public void addShape(@RequestBody Shape shape) {
        paintService.addShape(shape);
    }

    @DeleteMapping("/deleteShape")
    public void deleteShape(@RequestBody Point point) {
        paintService.deleteShape(point);
    }
}
