package examples.shapes;

import java.awt.*;
import java.io.File;

public class IntrinsicEmbedded extends EmbeddedImage {
    private String imageLoc;
    public IntrinsicEmbedded(String imageLoc){ this.imageLoc = imageLoc; }

    @Override
    public double getArea() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void draw(Graphics G) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Point getCenter() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCenter(Point center) throws ShapeException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save(File fileLocation) {
        throw new UnsupportedOperationException();
    }

    public String getImageLoc() {
        return this.imageLoc;
    }
}
