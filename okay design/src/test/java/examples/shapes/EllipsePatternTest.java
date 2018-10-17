package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class EllipsePatternTest {

    @Test
    public void getObject() throws ShapeException {
        EllipsePattern ellipsePattern = new EllipsePattern();
        String[] line = {"ellipse","1","2","1","1"};
        Shape myShape =ellipsePattern.getObject(line,null,null);
        assertEquals(myShape.getCenter().getX(),1,0);
        assertEquals(myShape.getCenter().getY(),2,0);
    }
}