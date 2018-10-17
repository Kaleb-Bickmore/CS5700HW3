package examples.shapes;

import java.awt.*;
import java.io.*;

/**
 * Circle
 *
 * This class represents circle objects that can be moved and scales.  Users of a circle can also get its area.
 *
 */
@SuppressWarnings("WeakerAccess")
public class Circle implements Shape {
    Point center;
    private double xAxisRadius;

    /**
     * Constructor with a Point for center
     *
     * @param center            The x-location of the center of the circle -- must be a valid point
     * @param xAxisRadius       The xAxisRadius of the circle -- must be greater or equal to zero.
     * @throws ShapeException   The exception thrown if the x, y, or z are not valid
     */
    public Circle(Point center, double xAxisRadius) throws ShapeException {
        if (center == null)
            throw new ShapeException("Invalid center");
        this.center = center;
        Validator.validatePositiveDouble(xAxisRadius, "Invalid xAxisRadius");
        this.xAxisRadius = xAxisRadius;


        this.xAxisRadius = xAxisRadius;
    }

    /**
     * @return  The xAxisRadius of the circle
     */
    public double getXAxisRadius() { return xAxisRadius; }

    /**
     *
     * @param xAxisRadius this is a positive integer representing the radius of the circle
     * @throws ShapeException throws exception if radius is not valid
     */
    public void setXAxisRadius(double xAxisRadius) throws ShapeException {
        Validator.validatePositiveDouble(xAxisRadius, "Invalid xAxisRadius");
        this.xAxisRadius = xAxisRadius;
    }


    /**
     * Scale the circle
     *
     * @param scaleFactor       a non-negative double that represents the percentage to scale the circle.
     *                          0>= and <1 to shrink.
     *                          >1 to grow.
     * @throws ShapeException   Exception thrown if the scale factor is not valid
     */
    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        xAxisRadius *= scaleFactor;
    }

    @Override
    public void add(Shape myShape) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Shape myShape) {
        throw new UnsupportedOperationException();

    }

    /**
     * @return  The area of the circle.
     */
    @Override
    public double getArea() {
        return Math.PI * Math.pow(xAxisRadius, 2);
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();

    }

    @Override
    public void draw(Graphics G) {
        G.drawOval((int)this.center.getX(),(int)this.center.getY(),
                (int)(this.getXAxisRadius()*2), (int)(this.getXAxisRadius()*2));

    }

    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {
        this.setCenter(new Point(this.getCenter().getX()+deltaX,this.getCenter().getY()+deltaY));
    }

    @Override
    public Point getCenter() {
        return this.center;
    }

    @Override
    public void setCenter(Point center) throws ShapeException {
        if (center == null)
            throw new ShapeException("Invalid center");
        this.center = center;
    }
    @Override
    public void save(File fileLocation) throws IOException {
        FileWriter fw = new FileWriter(fileLocation.getPath(),fileLocation.exists());
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("circle,"+this.center.getX()+","+this.center.getY()+","+this.xAxisRadius);
        pw.close();
    }


}
