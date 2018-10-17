
package examples.shapes;

import java.awt.*;
import java.io.*;

/**
 *  Triangle
 *  This class represents a triangle that expands on the shape class.
 */

public class Triangle implements Shape {
    private Point[] vertices;
    private Point center;
    private double firstSide;
    private double secondSide;
    private double thirdSide;

    /**
     *
     /**
     *
     * @param point1        vertex point that we want to set as our triangles vertex
     * @param point2       vertex point that we want to set as our triangles vertex
     * @param point3         vertex point that we want to set as our triangles vertex
     * @throws ShapeException   throws exception if one of the sides is invalid or if the sides
     *                          do not make a valid triangle
     */
    public Triangle(Point point1, Point point2, Point point3 ) throws ShapeException {
        this.center =new Point((point1.getX()+point2.getX()+point3.getX())/3,
                (point1.getY()+point2.getY()+point3.getY())/3);
        Validator.validateTriangle(point1,point2,point3,"Invalid triangle");
        this.vertices = new Point[]{point1,point2,point3};
        this.firstSide = new Line(point1,point2).computeLength();
        this.secondSide = new Line(point2,point3).computeLength();
        this.thirdSide = new Line(point1,point3).computeLength();
    }

    /**
     * UNSUPPORTED METHOD
     */
    @Override
    public void add(Shape myShape) {
        throw new UnsupportedOperationException();
    }

    /**
     * UNSUPPORTED METHOD
     */
    @Override
    public void delete(Shape myShape) {
        throw new UnsupportedOperationException();

    }

    /**
     * This function uses Heron's formula to calculate the area of our triangle
     * @return area of the triangle
     */
    @Override
    public double getArea(){
        double s=(firstSide+secondSide+thirdSide)/2;
        return Math.sqrt(s*(s-firstSide)*(s-secondSide)*(s-thirdSide));
    }

    /**
     * UNSUPPORTED METHOD
     */
    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();

    }

    /**
     *
     * @param G graphics that we will display our triangle to
     */
    @Override
    public void draw(Graphics G) {
        G.drawLine((int)this.vertices[0].getX(),(int)this.vertices[0].getY(),
                (int)this.vertices[1].getX(),(int)this.vertices[1].getY());
        G.drawLine((int)this.vertices[2].getX(),(int)this.vertices[2].getY(),
                (int)this.vertices[1].getX(),(int)this.vertices[1].getY());
        G.drawLine((int)this.vertices[0].getX(),(int)this.vertices[0].getY(),
                (int)this.vertices[2].getX(),(int)this.vertices[2].getY());

    }

    /**
     *
     * @param deltaX change in the x direction
     * @param deltaY change in the y direction
     * @throws ShapeException
     */
    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {
        this.setCenter(new Point(this.getCenter().getX()+deltaX,this.getCenter().getY()+deltaY));

    }

    /**
     *
     * @return the center of our triangle
     */
    @Override
    public Point getCenter() {
        return this.center;
    }

    /**
     *
     * @param point1        vertex point that we want to set as our triangles vertex
     * @param point2       vertex point that we want to set as our triangles vertex
     * @param point3         vertex point that we want to set as our triangles vertex
     * @throws ShapeException   throws exception if one of the sides is invalid or if the sides
     *                          do not make a valid triangle
     */
    public void setVertices(Point point1, Point point2, Point point3)throws ShapeException{
        Validator.validateTriangle(point1,point2,point3,"Invalid triangle");
        this.firstSide = new Line(point1,point2).computeLength();
        this.secondSide = new Line(point2,point3).computeLength();
        this.thirdSide = new Line(point1,point3).computeLength();
        this.vertices=new Point[]{point1,point2,point3};


    }

    /**
     *
     * @return the vertices of our triangle
     */
    public Point[] getVertices(){ return this.vertices; }

    /**
     *
     * @return the lengths of the sides of the triangle
     */
    public double[] getSideLength(){
        double[] sideLengths = {firstSide,secondSide,thirdSide};
        return sideLengths;}

    /**
     *
     * @param center
     * @throws ShapeException
     */
    public void setCenter(Point center)throws ShapeException{
        double deltaX = center.getX()-this.center.getX();
        double deltaY = center.getY() - this.center.getY();
        this.center = center;
        Point point1 =new Point(this.vertices[0].getX()+deltaX,this.vertices[0].getY()+deltaY);
        Point point2 =new Point(this.vertices[1].getX()+deltaX,this.vertices[1].getY()+deltaY);
        Point point3 =new Point(this.vertices[2].getX()+deltaX,this.vertices[2].getY()+deltaY);
        this.setVertices(point1,point2,point3);
    }

    /**
     *
     * @param fileLocation the location where we want to save the shape
     */
    @Override
    public void save(File fileLocation) throws IOException {
        FileWriter fw = new FileWriter(fileLocation.getPath(),fileLocation.exists());
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("triangle,"+this.vertices[0].getX()+","+this.vertices[0].getY()+","+
                                               this.vertices[1].getX()+","+this.vertices[1].getY()+","+
                                               this.vertices[2].getX()+","+this.vertices[2].getY());
        pw.close();

    }



}
