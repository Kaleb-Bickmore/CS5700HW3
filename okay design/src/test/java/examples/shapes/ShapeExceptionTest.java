package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShapeExceptionTest {

    @Test
    public void testConstruction() {
        ShapeException exception = new ShapeException();
        assertNull(exception.getMessage());

        exception = new ShapeException("test message");
        assertEquals("test message", exception.getMessage());
    }
}