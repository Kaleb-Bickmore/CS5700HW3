package examples.shapes;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public interface Shape {
    void add(Shape myShape);
    void delete(Shape myShape);
    double getArea();
    void deleteAll();
    void draw(Graphics G);
    void move(double deltaX, double deltaY) throws ShapeException;
    Point getCenter();
    void setCenter(Point center)throws ShapeException;
    void save(File FileLocation) throws IOException;
}

