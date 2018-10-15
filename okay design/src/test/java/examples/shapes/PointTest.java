package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void testValidConstruction() throws Exception {
        Point p1 = new Point(1,2);
        assertEquals(1, p1.getX(), 0);
        assertEquals(2, p1.getY(), 0);

        p1 = new Point(1.111,2.222);
        assertEquals(1.111, p1.getX(), 0);
        assertEquals(2.222, p1.getY(), 0);
    }

    @Test
    public void testInvalidConstruction() {

        try {
            new Point(1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Point(1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Point(1,Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid y-location", e.getMessage());
        }

        try {
            new Point(Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Point(Double.NEGATIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

        try {
            new Point(Double.NaN, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid x-location", e.getMessage());
        }

    }

    @Test
    public void testMoveX() throws Exception {
        Point p1 = new Point(1,2);

        p1.moveX(10);
        assertEquals(11, p1.getX(), 0);
        assertEquals(2, p1.getY(), 0);

        p1.moveX(0.1234);
        assertEquals(11.1234, p1.getX(), 0);
        assertEquals(2, p1.getY(), 0);

        p1.moveX(-20);
        assertEquals(-8.8766, p1.getX(), 0);
        assertEquals(2, p1.getY(), 0);

        p1.moveX(0);
        assertEquals(-8.8766, p1.getX(), 0);
        assertEquals(2, p1.getY(), 0);

        try {
            p1.moveX(Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

        try {
            p1.moveX(Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

        try {
            p1.moveX(Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

    }

    @Test
    public void testMoveY() throws Exception {
        Point p1 = new Point(1,2);

        p1.moveY(10);
        assertEquals(1, p1.getX(), 0);
        assertEquals(12, p1.getY(), 0);

        p1.moveY(0.1234);
        assertEquals(1, p1.getX(), 0);
        assertEquals(12.1234, p1.getY(), 0);

        p1.moveY(-20);
        assertEquals(1, p1.getX(), 0);
        assertEquals(-7.8766, p1.getY(), 0);

        p1.moveY(0);
        assertEquals(1, p1.getX(), 0);
        assertEquals(-7.8766, p1.getY(), 0);

        try {
            p1.moveY(Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            p1.moveY(Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            p1.moveY(Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

    }

    @Test
    public void testMove() throws Exception {
        Point p1 = new Point(1,2);

        p1.move(10, 20);
        assertEquals(11, p1.getX(), 0);
        assertEquals(22, p1.getY(), 0);

        p1.move(0.222, 0.333);
        assertEquals(11.222, p1.getX(), 0);
        assertEquals(22.333, p1.getY(), 0);

        p1.move(-0.222, -0.333);
        assertEquals(11, p1.getX(), 0);
        assertEquals(22, p1.getY(), 0);

        p1.move(-20, -30);
        assertEquals(-9, p1.getX(), 0);
        assertEquals(-8, p1.getY(), 0);

        try {
            p1.move(1, Double.POSITIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            p1.move(1, Double.NEGATIVE_INFINITY);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            p1.move(1, Double.NaN);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-y value", e.getMessage());
        }

        try {
            p1.move(Double.POSITIVE_INFINITY, 1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

        try {
            p1.move(Double.NEGATIVE_INFINITY,1 );
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

        try {
            p1.move(Double.NaN,1);
            fail("Expected exception not thrown");
        } catch (Exception e) {
            assertEquals("Invalid delta-x value", e.getMessage());
        }

    }

    @Test
    public void testClone() throws Exception {
        Point p1 = new Point(-123.45,-23.45);
        assertEquals(-123.45, p1.getX(), 0);
        assertEquals(-23.45, p1.getY(), 0);

        Point p2 = p1.copy();
        assertNotSame(p1, p2);
        assertEquals(p1.getX(), p2.getX(), 0);
        assertEquals(p1.getY(), p2.getY(), 0);
    }
}