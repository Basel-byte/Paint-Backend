package com.pro.paint.controller;


import com.pro.paint.model.Shape;
import com.pro.paint.service.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/all")
public class PaintController {

    @Autowired
    PaintService paintService;

    @GetMapping("/shapes")
    public List<Shape> getAllShapes() {
        return paintService.getAllShapes();
    }
}
