package examples.shapes;

import java.awt.*;
import java.io.*;

/**
 *  Square
 *
 *  This represents a square class that extends on the shape class.
 */
public class Square implements Shape {
    private double size;
    private Point [] vertices;
    private Point center;
    /**
     *
     * @param center center of our square
     * @param size size of our square
     * @throws ShapeException throws exception if the size of the square is invalid
     */
    public Square(Point center, double size) throws ShapeException{
        this.center = center;
        Validator.validatePositiveDouble(size,"Invalid size");
        this.size = size;
        Point point1 = new Point(center.getX()-(size/2),center.getY()-(size/2));
        Point point2 = new Point(center.getX()-(size/2),center.getY()+(size/2));
        Point point3 = new Point(center.getX()+(size/2),center.getY()+(size/2));
        Point point4 = new Point(center.getX()+(size/2),center.getY()-(size/2));
        Point[] allVertices={point1,point2,point3,point4};
        this.vertices=allVertices;
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
     *
     * @return Area of our square
     */
    @Override
    public double getArea(){return size*size;}

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();

    }

    /**
     *
     * @return size of our square
     */

    public double getSize() {
        return size;
    }

    /**
     *
     * @param size The size that we will set for the square
     * @throws ShapeException throws exception if the size is invalid
     */
    public void setSize(double size)throws ShapeException {
        Validator.validatePositiveDouble(size, "Invalid size");
        this.size = size;
    }
    public void setCenter(Point center)throws ShapeException{
        if (center == null) {
            throw new ShapeException("Invalid center");
        } else {
            this.center = center;
            Point point1 = new Point(center.getX() - (size / 2), center.getY() - (size / 2));
            Point point2 = new Point(center.getX() - (size / 2), center.getY() + (size / 2));
            Point point3 = new Point(center.getX() + (size / 2), center.getY() + (size / 2));
            Point point4 = new Point(center.getX() + (size / 2), center.getY() - (size / 2));
            Point[] allVertices = {point1, point2, point3, point4};
            this.vertices = allVertices;
        }
    }
    /**
     *
     * @return vertices of the square
     */
    public Point[] getVertices(){return vertices;}

    /**
     *
     * @param deltaX            a delta change for the x-location of the square
     * @param deltaY            a delta change for the y-location of the square
     * @throws ShapeException
     */
    @Override
    public void move(double deltaX,double deltaY)throws ShapeException{
        this.setCenter(new Point(this.getCenter().getX()+deltaX,this.getCenter().getY()+deltaY));

    }

    @Override
    public Point getCenter() {
        return this.center;
    }

    /**
     *
     * @param fileLocation the location that we want to save the square to
     */
    @Override
    public void save(File fileLocation) throws IOException {
        FileWriter fw = new FileWriter(fileLocation.getPath(),fileLocation.exists());
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("square,"+this.center.getX()+","+this.center.getY()+","+this.size);
        pw.close();
    }
    @Override
    public void draw(Graphics G) {
        G.drawRect((int)this.center.getX(),(int)this.center.getY(),(int)this.size,(int)this.size);
//todo add drawing

    }

}
