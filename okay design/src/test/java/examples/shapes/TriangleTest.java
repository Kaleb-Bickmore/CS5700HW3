package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,2);
        Point point3 = new Point(2,0);
        Triangle myTriangle= new Triangle(point1,point2,point3);
        Point[] comparePoints = {point1,point2,point3};
        Point[] myVertices= myTriangle.getVertices();
        for (int i=0;i <myVertices.length;i++){
            assertEquals(myVertices[i].getX(),comparePoints[i].getX(),0.0);
            assertEquals(myVertices[i].getY(),comparePoints[i].getY(),0.0);
        }
        assertEquals(myTriangle.getCenter().getX(),(point1.getX()+point2.getX()+point3.getX())/3,0.0001);
        assertEquals(myTriangle.getCenter().getY(),(point1.getY()+point2.getY()+point3.getY())/3,0.0001);

    }

    @Test
    public void testInvalidConstruction() throws ShapeException {
        try {
            Triangle myTriangle = new Triangle(null, null, null);
            fail("exception did not occur");
        }catch (NullPointerException e){
            assertEquals(e.getMessage(),null);
        }
    }

    @Test
    public void testComputeArea() throws ShapeException{
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,2);
        Point point3 = new Point(2,0);
        Triangle myTriangle= new Triangle(point1,point2,point3);
        assertEquals(2,myTriangle.getArea(),0.0001);
        }

    @Test
    public void testGetSideLengths() throws ShapeException{
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,2);
        Point point3 = new Point(2,0);
        Triangle myTriangle= new Triangle(point1,point2,point3);
        assertEquals(myTriangle.getSideLength()[0],2.00000,0.00001);
        assertEquals(myTriangle.getSideLength()[1],2.82843,0.00001);
        assertEquals(myTriangle.getSideLength()[2],2.00000,0.00001);


    }

    @Test
    public void testSetVertices() throws ShapeException {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 2);
        Point point3 = new Point(2, 0);
        Triangle myTriangle = new Triangle(point1, point2, point3);
        Point newPoint1 = new Point(1, 1);
        Point newPoint2 = new Point(1, 3);
        Point newPoint3 = new Point(3, 1);
        myTriangle.setVertices(newPoint1,newPoint2,newPoint3);
        Point[] comparePoints = {newPoint1,newPoint2,newPoint3};
        Point[] myVertices = myTriangle.getVertices();
        for (int i = 0; i < myVertices.length; i++) {
            assertEquals(myVertices[i].getX(), comparePoints[i].getX(), 0.0);
            assertEquals(myVertices[i].getY(), comparePoints[i].getY(), 0.0);
        }
    }

    @Test
    public void testGetVertices() throws ShapeException{
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,2);
        Point point3 = new Point(2,0);
        Triangle myTriangle= new Triangle(point1,point2,point3);
        Point[] comparePoints = {point1,point2,point3};
        Point[] myVertices= myTriangle.getVertices();
        for (int i=0;i <myVertices.length;i++){
            assertEquals(myVertices[i].getX(),comparePoints[i].getX(),0.0);
            assertEquals(myVertices[i].getY(),comparePoints[i].getY(),0.0);
        }

    }
    @Test
    public void testSetCenter()throws ShapeException{
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,2);
        Point point3 = new Point(2,0);
        Triangle myTriangle= new Triangle(point1,point2,point3);
        Point center = myTriangle.getCenter();
        assertEquals(center.getX(),myTriangle.getCenter().getX(),0);
        assertEquals(center.getY(),myTriangle.getCenter().getY(),0);
        center = new Point(center.getX()+1,center.getY()+1);
        myTriangle.setCenter(center);
        assertEquals(center.getX(),myTriangle.getCenter().getX(),0);
        assertEquals(center.getY(),myTriangle.getCenter().getY(),0);




    }
    @Test
    public void move() throws ShapeException {
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,2);
        Point point3 = new Point(2,0);
        Triangle myTriangle= new Triangle(point1,point2,point3);
        point1 = new Point(1,1);
        point2 = new Point(1,3);
        point3 = new Point(3,1);
        Point[] comparePoints = {point1,point2,point3};
        Point oldCenter = myTriangle.getCenter();
        myTriangle.move(1,1);
        Point[] myVertices= myTriangle.getVertices();
        for (int i=0;i <myVertices.length;i++){
            assertEquals(myVertices[i].getX(),comparePoints[i].getX(),0.0001);
            assertEquals(myVertices[i].getY(),comparePoints[i].getY(),0.0001);
        }
        assertEquals(oldCenter.getX()+1,myTriangle.getCenter().getX(),.0001);
        assertEquals(oldCenter.getY()+1,myTriangle.getCenter().getY(),.0001);

    }

    @Test
    public void add() throws ShapeException {
        Point point1 = new Point(0,0);
        Point point2 = new Point(0,2);
        Point point3 = new Point(2,0);
        Triangle myTriangle= new Triangle(point1,point2,point3);
        try{
            myTriangle.add(new Square(point1,12));
        }catch (UnsupportedOperationException e){
            assertNull(e.getMessage());
        }
    }

    @Test
    public void delete() throws ShapeException {

        Point point1 = new Point(0,0);
        Point point2 = new Point(0,2);
        Point point3 = new Point(2,0);
        Triangle myTriangle= new Triangle(point1,point2,point3);
        try{
            myTriangle.delete(new Square(point1,12));
        }catch (UnsupportedOperationException e){
            assertNull(e.getMessage());
        }
    }

    @Test
    public void deleteAll() throws ShapeException {

        Point point1 = new Point(0,0);
        Point point2 = new Point(0,2);
        Point point3 = new Point(2,0);
        Triangle myTriangle= new Triangle(point1,point2,point3);
        try{
            myTriangle.deleteAll();
        }catch (UnsupportedOperationException e){
            assertNull(e.getMessage());
        }
    }


}