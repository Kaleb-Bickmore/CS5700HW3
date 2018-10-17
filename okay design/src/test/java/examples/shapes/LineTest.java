package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point p1 = new Point(1,2);
        Point p2 = new Point(4, 10);

        Line myLine = new Line(p1, p2);
        assertSame(p1, myLine.getPoint1());
        assertSame(p2, myLine.getPoint2());

        p1 = new Point(1.4,2.5);
        p2 = new Point(4.6, 10.7);
        myLine = new Line(p1, p2);
        assertSame(p1, myLine.getPoint1());
        assertSame(p2, myLine.getPoint2());

    }
    @Test
    public void testInvalidConstruction() throws Exception {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 10);

        try {
            new Line(p1, null);
            fail("Expected exception not thrown for when the first parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid Point", e.getMessage());
        }

        try {
            new Line(null, p2);
            fail("Expected exception not thrown for when the second parameter is null");
        } catch (ShapeException e) {
            assertEquals("Invalid Point", e.getMessage());
        }


        try {
            new Line(p1, p1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("A line must have a length > 0", e.getMessage());
        }
    }
    @Test
    public void testMove() throws ShapeException {
        Line myLine = new Line(new Point(1, 2),new Point( 4, 10));

        myLine.move(3, 4);
        assertEquals(4, myLine.getPoint1().getX(), 0);
        assertEquals(6, myLine.getPoint1().getY(), 0);
        assertEquals(7, myLine.getPoint2().getX(), 0);
        assertEquals(14, myLine.getPoint2().getY(), 0);

        myLine.move(.4321, .7654);
        assertEquals(4.4321, myLine.getPoint1().getX(), 0);
        assertEquals(6.7654, myLine.getPoint1().getY(), 0);
        assertEquals(7.4321, myLine.getPoint2().getX(), 0);
        assertEquals(14.7654, myLine.getPoint2().getY(), 0);

        myLine.move(-0.4321, -0.7654);
        assertEquals(4, myLine.getPoint1().getX(), 0);
        assertEquals(6, myLine.getPoint1().getY(), 0);
        assertEquals(7, myLine.getPoint2().getX(), 0);
        assertEquals(14, myLine.getPoint2().getY(), 0);
    }

    @Test
    public void testComputeLength() throws ShapeException {

        Line myLine = new Line(new Point(1, 2),new Point( 4, 10));
        assertEquals(8.544, myLine.computeLength(), 0.001);

        myLine = new Line(new Point(1, 2),new Point( 1, 3));
        assertEquals(Math.sqrt(1), myLine.computeLength(), 0.001);

    }

    @Test
    public void testComputeSlope() throws ShapeException {
        Line myLine = new Line(new Point(2, 2),new Point( 4, 10));
        assertEquals(4.0, myLine.computeSlope(), 0.1);


        myLine = new Line(new Point(2, 2),new Point( 2, 4));
        assertEquals(Double.POSITIVE_INFINITY, myLine.computeSlope(), 0.1);

        myLine = new Line(new Point(2, 4 ),new Point(2, 2));
        assertEquals(Double.NEGATIVE_INFINITY, myLine.computeSlope(), 0.1);
    }
    @Test
    public void testSetCenter() throws ShapeException{
        Line myLine = new Line(new Point(0, 0),new Point( 2, 2));
        myLine.getCenter();
        assertEquals( myLine.getCenter().getX(),1, 0);
        assertEquals( myLine.getCenter().getY(),1, 0);
        myLine.setCenter(new Point(2,2));
        assertEquals( myLine.getCenter().getX(),2, 0);
        assertEquals( myLine.getCenter().getY(),2, 0);
        assertEquals( myLine.getPoint1().getX(),1, 0);
        assertEquals( myLine.getPoint1().getY(),1, 0);
        assertEquals( myLine.getPoint2().getX(),3, 0);
        assertEquals( myLine.getPoint2().getY(),3, 0);

    }
    @Test
    public void addTest() throws ShapeException {
        Line myLine = new Line(new Point(0, 0),new Point( 2, 2));
        try{
            myLine.add(new Square(new Point(1,1),23));
        }catch (UnsupportedOperationException e){
            assertNull(e.getMessage());
        }
    }

    @Test
    public void deleteTest() throws ShapeException {
        Line myLine = new Line(new Point(0, 0),new Point( 2, 2));
        try{
            myLine.delete(new Square(new Point(1,1),23));
        }catch (UnsupportedOperationException e){
            assertNull(e.getMessage());
        }
    }

    @Test
    public void getAreaTest() throws ShapeException {
        Line myLine = new Line(new Point(0, 0),new Point( 2, 2));
        assertEquals(myLine.getArea(),0,0);
    }

    @Test
    public void deleteAllTest() throws ShapeException {
        Line myLine = new Line(new Point(0, 0),new Point( 2, 2));
        try{
            myLine.deleteAll();
        }catch (UnsupportedOperationException e){
            assertNull(e.getMessage());
        }
    }

}