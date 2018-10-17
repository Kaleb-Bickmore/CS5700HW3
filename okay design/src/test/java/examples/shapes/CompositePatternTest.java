package examples.shapes;

import org.junit.Test;

import java.util.HashMap;
import java.util.Scanner;

import static org.junit.Assert.*;

public class CompositePatternTest {

    @Test
    public void getObject() throws ShapeException {
        HashMap<String, StrategyPattern> objectStrategy = new HashMap<String, StrategyPattern>();
        objectStrategy.put("composite",new CompositePattern());
        objectStrategy.put("circle",new CirclePattern());
        objectStrategy.put("ellipse",new EllipsePattern());
        objectStrategy.put("embeddedimage",new EmbeddedPattern());
        objectStrategy.put("rectangle",new RectPattern());
        objectStrategy.put("square",new SquarePattern());
        objectStrategy.put("triangle",new TrianglePattern());
        objectStrategy.put("line",new LinePattern());
        String line = "circle,1,2,1";
        Scanner scnr = new Scanner(line);
        String[] inputLine = {"composite","1","2","1",};
        CompositePattern compositePattern = new CompositePattern();
        Shape myShape =compositePattern.getObject(inputLine,scnr,objectStrategy);
        assertEquals(myShape.getCenter().getX(),1,0);
        assertEquals(myShape.getCenter().getY(),2,0);

    }
}