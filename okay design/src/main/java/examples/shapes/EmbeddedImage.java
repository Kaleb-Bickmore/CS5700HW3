package examples.shapes;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class EmbeddedImage implements Shape{


    @Override
    public void add(Shape myShape) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Shape myShape) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract void draw(Graphics G);

    @Override
    public abstract void move(double deltaX, double deltaY) throws ShapeException ;

    @Override
    public abstract Point getCenter();

    @Override
    public abstract void setCenter(Point center) throws ShapeException;

    @Override
    public abstract void save(File FileLocation)throws IOException;
}
