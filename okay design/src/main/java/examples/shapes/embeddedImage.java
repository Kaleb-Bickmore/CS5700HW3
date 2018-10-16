package examples.shapes;

import java.awt.*;

public class embeddedImage implements ShapeComponent {

    @Override
    public void add(ShapeComponent myShape) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(ShapeComponent myShape) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getArea() {

        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {

        throw new UnsupportedOperationException();

    }

    @Override
    public void draw(Graphics G) {

    }

    @Override
    public void move(double deltaX, double deltaY)  {

    }
}
