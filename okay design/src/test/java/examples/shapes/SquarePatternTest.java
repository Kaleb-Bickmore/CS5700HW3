package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquarePatternTest {

    @Test
    public void getObject() throws ShapeException {
        SquarePattern squarePattern = new SquarePattern();
        String[] line = {"square","1","2","2"};
        Shape myShape =squarePattern.getObject(line,null,null);
        assertEquals(myShape.getCenter().getX(),1,0);
        assertEquals(myShape.getCenter().getY(),2,0);
    }
}