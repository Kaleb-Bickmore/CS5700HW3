package examples.shapes;

import java.awt.*;

public interface ShapeComponent {
    void add(ShapeComponent myShape);
    void delete(ShapeComponent myShape);
    double getArea();
    void deleteAll();
    void draw(Graphics G);
    void move(double deltaX, double deltaY) throws ShapeException;
}
