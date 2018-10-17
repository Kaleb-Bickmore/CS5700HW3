package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectPatternTest {

    @Test
    public void getObject() throws ShapeException {
        RectPattern rectPattern = new RectPattern();
        String[] line = {"rectangle","1","2","2","2"};
        Shape myShape =rectPattern.getObject(line,null,null);
        assertEquals(myShape.getCenter().getX(),1,0);
        assertEquals(myShape.getCenter().getY(),2,0);
    }
}