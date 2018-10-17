package examples.shapes;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CirclePatternTest {

    @Test
    public void getObject() throws ShapeException {
        CirclePattern circlePattern = new CirclePattern();
        String[] line = {"circle","1","2","1"};
        Shape myShape =circlePattern.getObject(line,null,null);
        assertEquals(myShape.getCenter().getX(),1,0);
        assertEquals(myShape.getCenter().getY(),2,0);
    }


}