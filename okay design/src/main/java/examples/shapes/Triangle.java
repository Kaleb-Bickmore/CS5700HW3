
package examples.shapes;

/**
 *  Triangle
 *  This class represents a triangle that expands on the shape class.
 */

public class Triangle extends Shape {
    Point[] vertices;
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
        super(new Point((point1.getX()+point2.getX()+point3.getX())/3,
                (point1.getY()+point2.getY()+point3.getY())/3));
        Validator.validateTriangle(point1,point2,point3,"Invalid triangle");
        this.vertices = new Point[]{point1,point2,point3};
        this.firstSide = new Line(point1,point2).computeLength();
        this.secondSide = new Line(point2,point3).computeLength();
        this.thirdSide = new Line(point1,point3).computeLength();
    }

    /**
     * This function uses Heron's formula to calculate the area of our triangle
     * @return area of the triangle
     */
    public double getArea(){
        double s=(firstSide+secondSide+thirdSide)/2;
        return Math.sqrt(s*(s-firstSide)*(s-secondSide)*(s-thirdSide));
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
    public void setCenter(Point center)throws ShapeException{
        throw new ShapeException("cannot set center of triangle");
    }


}
