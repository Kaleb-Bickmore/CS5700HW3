package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {
    @Test
    public void testValidConstruction() throws ShapeException {
        Point center = new Point(1,2);
        Square mySquare = new Square(center, 5);
        assertEquals(5, mySquare.getSize(), 0);
        mySquare = new Square(1.3, 2.6, 2.5);
        assertEquals(2.5, mySquare.getSize(), 0);
    }

    @Test
    public void testInvalidConstruction() throws Exception {

        try {
            new Square( new Point(1, 2), Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid size", e.getMessage());
        }

        try {
            new Square(new Point(1, 2), Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid size", e.getMessage());
        }

        try {
            new Square(new Point(1, 2), Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid size", e.getMessage());
        }

    }

    @Test
    public void testGetArea() throws ShapeException {
        Point center = new Point(2,1);
        Square mySquare = new Square(center, 5);
        assertEquals(25,mySquare.getArea(),0);
        Square newSquare = new Square(center, 6.43);
        assertEquals(41.3449,newSquare.getArea(),0.0001);

    }

    @Test
    public void testGetSize() throws ShapeException{
        Point center = new Point(2,1);
        Square mySquare = new Square(center, 5);
        assertEquals(5,mySquare.getSize(),0);
        Square newSquare = new Square(center, 6.43);
        assertEquals(6.43,newSquare.getSize(),0);
    }

    @Test
    public void testSetSize() throws ShapeException{
        Point center = new Point(2,1);
        Square mySquare = new Square(center, 5);
        mySquare.setSize(6);
        assertEquals(6,mySquare.getSize(),0);
        mySquare.setSize(6.43);
        assertEquals(6.43,mySquare.getSize(),0);
        try{
            mySquare.setSize(Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid size", e.getMessage());
        }
        try{
            mySquare.setSize(Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid size", e.getMessage());
        }
        try{
            mySquare.setSize(Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid size", e.getMessage());
        }
    }
    @Test
    public void testGetVertices() throws ShapeException{
        Point center = new Point(1,1);
        Square mySquare = new Square(center, 2);
        Point[] comparePoints={new Point(0.0,0.0),new Point(0.0,2.0),
                new Point(2.0,2.0),new Point(2.0,0.0)};
        Point[] myVertices= mySquare.getVertices();
        for (int i=0;i <myVertices.length;i++){
            assertEquals(myVertices[i].getX(),comparePoints[i].getX(),0.0);
            assertEquals(myVertices[i].getY(),comparePoints[i].getY(),0.0);

        }
    }
    @Test
    public void testSetCenter()throws ShapeException{
        Point center = new Point(0,0);
        Square mySquare = new Square(center, 2);
        try {
            mySquare.setCenter(null);
            fail("expected exception");
        }catch (ShapeException e){
            assertEquals("Invalid center",e.getMessage());
        }
        mySquare.setCenter(new Point(1,1));
        Point[] comparePoints={new Point(0.0,0.0),new Point(0.0,2.0),
                new Point(2.0,2.0),new Point(2.0,0.0)};
        Point[] myVertices= mySquare.getVertices();
        for (int i=0;i <myVertices.length;i++){
            assertEquals(myVertices[i].getX(),comparePoints[i].getX(),0.0);
            assertEquals(myVertices[i].getY(),comparePoints[i].getY(),0.0);

        }
    }
    @Test
    public void testMove()throws ShapeException{
        Point center = new Point(0,0);
        Square mySquare = new Square(center, 2);
        mySquare.move(1,1);
        Point[] comparePoints={new Point(0.0,0.0),new Point(0.0,2.0),
                new Point(2.0,2.0),new Point(2.0,0.0)};
        Point[] myVertices= mySquare.getVertices();
        for (int i=0;i <myVertices.length;i++) {
            assertEquals(myVertices[i].getX(), comparePoints[i].getX(), 0.0);
            assertEquals(myVertices[i].getY(), comparePoints[i].getY(), 0.0);
        }

    }
}