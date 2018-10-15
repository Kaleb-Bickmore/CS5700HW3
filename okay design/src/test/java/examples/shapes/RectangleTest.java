package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {
    @Test
    public void testValidConstruction() throws ShapeException {
        Point center = new Point(1, 2);
        Rectangle myRectangle = new Rectangle(center, 5, 7);
        assertEquals(7, myRectangle.getWidth(), 0);
        myRectangle = new Rectangle(1.3, 2.6, 2.5, 7.3);
        assertEquals(7.3, myRectangle.getWidth(), 0);
    }

    @Test
    public void testInvalidConstruction() throws Exception {

        try {
            new Rectangle(new Point(1, 2), 1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid width", e.getMessage());
        }

        try {
            new Rectangle(new Point(1, 2), 1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid width", e.getMessage());
        }

        try {
            new Rectangle(new Point(1, 2), 1, Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid width", e.getMessage());
        }

    }

    @Test
    public void testGetArea() throws ShapeException {
        Point center = new Point(2, 1);
        Rectangle myRectangle = new Rectangle(center, 5, 5);
        assertEquals(25, myRectangle.getArea(), 0);
        Rectangle newRectangle = new Rectangle(center, 6.43, 7.49);
        assertEquals(48.1607, newRectangle.getArea(), 0.0001);

    }

    @Test
    public void testGetWidth() throws ShapeException {
        Point center = new Point(2, 1);
        Rectangle myRectangle = new Rectangle(center, 5, 10);
        assertEquals(10, myRectangle.getWidth(), 0);
        Rectangle newRectangle = new Rectangle(center, 1, 6.43);
        assertEquals(6.43, newRectangle.getWidth(), 0);
    }

    @Test
    public void testSetWidth() throws ShapeException {
        Point center = new Point(2, 1);
        Rectangle myRectangle = new Rectangle(center, 4, 2);
        myRectangle.setWidth(6);
        assertEquals(6, myRectangle.getWidth(), 0);
        myRectangle.setWidth(6.43);
        assertEquals(6.43, myRectangle.getWidth(), 0);
        try {
            myRectangle.setWidth(Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid width", e.getMessage());
        }
        try {
            myRectangle.setWidth(Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid width", e.getMessage());
        }
        try {
            myRectangle.setWidth(Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid width", e.getMessage());
        }
    }

    @Test
    public void testSetSize() throws ShapeException {
        Point center = new Point(2, 1);
        Rectangle myRectangle = new Rectangle(center, 4, 2);
        myRectangle.setSize(6, 8);
        assertEquals(6, myRectangle.getHeight(), 0);
        assertEquals(8, myRectangle.getWidth(), 0);
        myRectangle.setSize(6.43, 8.21);
        assertEquals(6.43, myRectangle.getHeight(), 0);
        assertEquals(8.21, myRectangle.getWidth(), 0);
        try {
            myRectangle.setSize(1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid width", e.getMessage());
        }
        try {
            myRectangle.setSize(1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid width", e.getMessage());
        }
        try {
            myRectangle.setSize(1, Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid width", e.getMessage());
        }
        try {
            myRectangle.setSize(Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid height", e.getMessage());
        }
        try {
            myRectangle.setSize(Double.NEGATIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid height", e.getMessage());
        }
        try {
            myRectangle.setSize(Double.NaN, 1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid height", e.getMessage());
        }
    }

    @Test
    public void testGetHeight() throws ShapeException {
        Point center = new Point(2, 1);
        Rectangle myRectangle = new Rectangle(center, 5, 10);
        assertEquals(5, myRectangle.getHeight(), 0);
        Rectangle newRectangle = new Rectangle(center, 1.43, 6.43);
        assertEquals(1.43, newRectangle.getHeight(), 0);
    }

    @Test
    public void testSetHeight() throws ShapeException {
        Point center = new Point(2, 1);
        Rectangle myRectangle = new Rectangle(center, 4, 2);
        myRectangle.setHeight(6);
        assertEquals(6, myRectangle.getHeight(), 0);
        myRectangle.setHeight(6.43);
        assertEquals(6.43, myRectangle.getHeight(), 0);
        try {
            myRectangle.setHeight(Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid height", e.getMessage());
        }
        try {
            myRectangle.setHeight(Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid height", e.getMessage());
        }
        try {
            myRectangle.setHeight(Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid height", e.getMessage());
        }
    }

    @Test
    public void testGetVertices() throws ShapeException {
        Point center = new Point(2, 1);
        Rectangle myRectangle = new Rectangle(center, 2, 4);
        Point[] comparePoints = {new Point(0.0, 0.0), new Point(0.0, 2.0),
                new Point(4.0, 2.0), new Point(4.0, 0.0)};
        Point[] myVertices = myRectangle.getVertices();
        for (int i = 0; i < myVertices.length; i++) {
            assertEquals(myVertices[i].getX(), comparePoints[i].getX(), 0.0);
            assertEquals(myVertices[i].getY(), comparePoints[i].getY(), 0.0);

        }
    }

    @Test
    public void testSetCenter() throws ShapeException {
        Point center = new Point(0, 0);
        Rectangle myRectangle = new Rectangle(center, 2, 4);
       try{
           myRectangle.setCenter(null);
           fail("expected exception");
       }catch (ShapeException e){
           assertEquals("Invalid center",e.getMessage());
       }
        myRectangle.setCenter(new Point(2, 1));
        Point[] comparePoints = {new Point(0.0, 0.0), new Point(0.0, 2.0),
                new Point(4.0, 2.0), new Point(4.0, 0.0)};
        Point[] myVertices = myRectangle.getVertices();
        for (int i = 0; i < myVertices.length; i++) {
            assertEquals(myVertices[i].getX(), comparePoints[i].getX(), 0.0);
            assertEquals(myVertices[i].getY(), comparePoints[i].getY(), 0.0);

        }
    }
    @Test
    public void testMove()throws ShapeException{
        Point center = new Point(0, 0);
        Rectangle myRectangle = new Rectangle(center, 2, 4);
        myRectangle.move(2, 1);
        Point[] comparePoints = {new Point(0.0, 0.0), new Point(0.0, 2.0),
                new Point(4.0, 2.0), new Point(4.0, 0.0)};
        Point[] myVertices = myRectangle.getVertices();
        for (int i = 0; i < myVertices.length; i++) {
            assertEquals(myVertices[i].getX(), comparePoints[i].getX(), 0.0);
            assertEquals(myVertices[i].getY(), comparePoints[i].getY(), 0.0);
        }

    }
}