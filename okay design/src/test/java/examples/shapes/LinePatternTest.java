package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinePatternTest {

    @Test
    public void getObject() throws ShapeException {
        LinePattern linePattern = new LinePattern();
        String[] line = {"line","0","0","2","2"};
        Shape myShape =linePattern.getObject(line,null,null);
        System.out.print("test");

        System.out.print(myShape.getCenter().getX());
        assertEquals(myShape.getCenter().getX(),1,0);
        assertEquals(myShape.getCenter().getY(),1,0);
    }
}