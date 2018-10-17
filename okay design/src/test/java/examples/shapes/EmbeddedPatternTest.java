package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmbeddedPatternTest {

    @Test
    public void getObject() throws ShapeException {
        EmbeddedPattern embeddedPattern = new EmbeddedPattern();
        String[] line = {"embeddedimage","1","2","5000","imageName"};
        Shape myShape =embeddedPattern.getObject(line,null,null);
        assertEquals(myShape.getCenter().getX(),1,0);
        assertEquals(myShape.getCenter().getY(),2,0);
    }
}