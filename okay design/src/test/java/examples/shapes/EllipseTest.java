package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class EllipseTest {

    @Test
    public void testValidConstruction() throws ShapeException {
        Point center = new Point(1,2);
        Ellipse myEllipse = new Ellipse(center, 5,2);
        assertSame(center, myEllipse.getCenter());
        assertEquals(2, myEllipse.getYAxisRadius(), 0);
        myEllipse = new Ellipse(1.3, 2.6, 2.5,10);
        assertEquals(1.3, myEllipse.getCenter().getX(), 0);
        assertEquals(2.6, myEllipse.getCenter().getY(), 0);
        assertEquals(10, myEllipse.getYAxisRadius(), 0);

    }

    @Test
    public void testInvalidConstruction() throws ShapeException {

        try {
            new Ellipse( new Point(1, 2),1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid yAxisRadius", e.getMessage());
        }

        try {
            new Ellipse(new Point(1, 2),1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid yAxisRadius", e.getMessage());
        }

        try {
            new Ellipse(new Point(1, 2),1, Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid yAxisRadius", e.getMessage());
        }

        try {
            new Ellipse(1, 2, 1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid yAxisRadius", e.getMessage());
        }

        try {
            new Ellipse(1, 2, 1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid yAxisRadius", e.getMessage());
        }

        try {
            new Ellipse(1, 2, 1,Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid yAxisRadius", e.getMessage());
        }
    }

    @Test
    public void getYAxisRadius() throws ShapeException {
        Point center = new Point(1,2);
        Ellipse myEllipse = new Ellipse(center, 5,2);
        assertEquals(2 , myEllipse.getYAxisRadius(),0);

    }

    @Test
    public void setYAxisRadius() throws ShapeException {
        Point center = new Point(1,2);
        Ellipse myEllipse = new Ellipse(center, 5,12);
        myEllipse.setYAxisRadius(2);
        assertEquals(2 , myEllipse.getYAxisRadius(),0);
        try {
            Ellipse myEllipse1 = new Ellipse(1, 2, 1, 10);
            myEllipse1.setYAxisRadius(Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid yAxisRadius", e.getMessage());
        }
        try {
            Ellipse myEllipse1 = new Ellipse(1, 2, 1, 10);
            myEllipse1.setYAxisRadius(Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid yAxisRadius", e.getMessage());
        }
        try {
            Ellipse myEllipse1 = new Ellipse(1, 2, 1, 10);
            myEllipse1.setYAxisRadius(Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid yAxisRadius", e.getMessage());
        }
    }

    @Test
    public void setAllRadius() throws ShapeException{
        Point center = new Point(1,2);
        Ellipse myEllipse = new Ellipse(center, 5,12);
        myEllipse.setAllRadius(2,4);
        assertEquals(2 , myEllipse.getXAxisRadius(),0);
        assertEquals(4 , myEllipse.getYAxisRadius(),0);
        try {
            Ellipse myEllipse1 = new Ellipse(1, 2, 1, 10);
            myEllipse1.setAllRadius(1,Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid yAxisRadius", e.getMessage());
        }
        try {
            Ellipse myEllipse1 = new Ellipse(1, 2, 1, 10);
            myEllipse1.setAllRadius(1,Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid yAxisRadius", e.getMessage());
        }
        try {
            Ellipse myEllipse1 = new Ellipse(1, 2, 1, 10);
            myEllipse1.setAllRadius(1,Double.NaN);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid yAxisRadius", e.getMessage());
        }
        try {
            Ellipse myEllipse1 = new Ellipse(1, 2, 1, 10);
            myEllipse1.setAllRadius(Double.NEGATIVE_INFINITY,1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid xAxisRadius", e.getMessage());
        }
        try {
            Ellipse myEllipse1 = new Ellipse(1, 2, 1, 10);
            myEllipse1.setAllRadius(Double.POSITIVE_INFINITY,1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid xAxisRadius", e.getMessage());
        }
        try {
            Ellipse myEllipse1 = new Ellipse(1, 2, 1, 10);
            myEllipse1.setAllRadius(Double.NaN,1);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid xAxisRadius", e.getMessage());
        }
    }

    @Test
    public void scale() throws ShapeException {
        Ellipse myEllipse = new Ellipse(1, 2,6, 4);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(2, myEllipse.getCenter().getY(), 0);
        assertEquals(6, myEllipse.getXAxisRadius(), 0);
        assertEquals(4, myEllipse.getYAxisRadius(), 0);

        myEllipse.scale(3);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(2, myEllipse.getCenter().getY(), 0);
        assertEquals(18, myEllipse.getXAxisRadius(), 0);
        assertEquals(12, myEllipse.getYAxisRadius(), 0);

        myEllipse.scale(.5);
        assertEquals(1, myEllipse.getCenter().getX(), 0);
        assertEquals(2, myEllipse.getCenter().getY(), 0);
        assertEquals(9, myEllipse.getXAxisRadius(), 0);
        assertEquals(6, myEllipse.getYAxisRadius(), 0);

        try {
            myEllipse.scale(Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid scale factor", e.getMessage());

        }

        try {
            myEllipse.scale(Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (ShapeException e) {
            assertEquals("Invalid scale factor", e.getMessage());
        }

        try {
            myEllipse.scale(Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid scale factor", e.getMessage());
        }
    }

    @Test
    public void computeArea() throws ShapeException {
        Ellipse myEllipse = new Ellipse(1, 2, 5,5);
        assertEquals(78.53975, myEllipse.computeArea(), 0.0001);

        myEllipse = new Ellipse(1, 2, 4.2,5.9);
        assertEquals(77.84867, myEllipse.computeArea(), 0.00001);

        myEllipse = new Ellipse(1, 2, 0,0);
        assertEquals(0, myEllipse.computeArea(), 0);
    }
}