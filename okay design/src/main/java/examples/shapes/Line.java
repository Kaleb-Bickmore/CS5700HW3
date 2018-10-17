package examples.shapes;

import java.awt.*;
import java.io.*;

/**
 *
 *  Line
 *
 *  This class represents line objects that can be moved.  Users of a line can also get its length and slope.
 *
 */
@SuppressWarnings("WeakerAccess")
public class Line implements Shape {
    private Point center;
    private Point point1;
    private Point point2;

    /**
     * Constructor based on x-y Locations
     * @param x1                The x-location of first point -- must be a valid double.
     * @param y1                The y-location of first point -- must be a valid double.
     * @param x2                The x-location of second point -- must be a valid double.
     * @param y2                The y-location of second point -- must be a valid double.
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public Line(double x1, double y1, double x2, double y2) throws ShapeException {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);

        if (computeLength() < 0.00000001)
            throw new ShapeException("A line must have a length > 0");
        center = new Point((x1+x2)/2,(y1+y2)/2);
    }

    /**
     *
     * @param point1            The first point -- must not be null
     * @param point2            The second point -- must not b e null
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    public Line(Point point1, Point point2) throws ShapeException {
        if (point1==null || point2==null)
            throw new ShapeException("Invalid Point");

        this.point1 = point1;
        this.point2 = point2;

        if (computeLength() < 0.00000001)
            throw new ShapeException("A line must have a length > 0");
    }

    /**
     * @return  The first point
     */
    public Point getPoint1() { return point1; }

    /**
     * @return  The second point
     */
    public Point getPoint2() { return point2; }


    @Override
    public void add(Shape myShape) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public void delete(Shape myShape) {
        throw  new UnsupportedOperationException();

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
        G.drawLine((int)this.point1.getX(),(int)this.point1.getY(),(int)this.point2.getX(),(int)this.point2.getY());
    }

    /**
     * Move a line
     *
     * @param deltaX            The delta x-location by which the line should be moved -- must be a valid double
     * @param deltaY            The delta y-location by which the line should be moved -- must be a valid double
     * @throws ShapeException   Exception throw if any parameter is invalid
     */
    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {
        point1.move(deltaX, deltaY);
        point2.move(deltaX, deltaY);
        this.center = new Point(this.center.getX()+deltaX,this.center.getY()+deltaY);
    }

    @Override
    public Point getCenter() {
        return this.center;
    }

    @Override
    public void setCenter(Point center)throws ShapeException  {
        double deltaX = center.getX()-this.center.getX();
        double deltaY = center.getY() - this.center.getY();
        this.move(deltaX,deltaY);
    }

    @Override
    public void save(File fileLocation) throws IOException {
        FileWriter fw = new FileWriter(fileLocation.getPath(),fileLocation.exists());
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("line,"+this.point1.getX()+","+this.point1.getY()+","+this.point2.getX()+","+this.point2.getY());
        pw.close();
    }

    /**
     * @return  The length of the line
     */
    public double computeLength() {
        return Math.sqrt(Math.pow(point2.getX() - point1.getX(), 2) +
                         Math.pow(point2.getY() - point1.getY(), 2));
    }

    /**
     * @return  The slope of the line
     */
    public double computeSlope() {
        return (point2.getY() - point1.getY())/(point2.getX() - point1.getX());
    }

}
