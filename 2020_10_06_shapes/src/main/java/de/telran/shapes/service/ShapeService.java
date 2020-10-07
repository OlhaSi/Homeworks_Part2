package de.telran.shapes.service;

import de.telran.shapes.model.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShapeService {

    public void drawShapes(@Autowired List<Shape> shapes) {
        //System.out.println(shapes.size());
        shapes.stream().forEach(Shape::draw);
    }
}
