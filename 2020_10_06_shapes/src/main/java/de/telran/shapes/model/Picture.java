package de.telran.shapes.model;

import java.util.Collections;
import java.util.List;

public class Picture implements Shape {

    private final List<Shape> shapes;

    public Picture(List<Shape> shapes) {
        this.shapes = Collections.unmodifiableList(shapes);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    /**
     * iterates over the shapes and draws it
     */
    @Override
    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
