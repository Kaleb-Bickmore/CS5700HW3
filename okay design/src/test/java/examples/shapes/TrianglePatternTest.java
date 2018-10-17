package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrianglePatternTest {

    @Test
    public void getObject() throws ShapeException {
        TrianglePattern trianglePattern = new TrianglePattern();
        String[] line = {"triangle","0","0","0","2","2","0"};
        Shape myShape =trianglePattern.getObject(line,null,null);
        assertEquals(myShape.getCenter().getX(),.666666,0.00001);
        assertEquals(myShape.getCenter().getY(),.666666,0.00001);
    }
}