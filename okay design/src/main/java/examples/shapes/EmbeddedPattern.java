package examples.shapes;

import java.util.HashMap;
import java.util.Scanner;

public class EmbeddedPattern implements StrategyPattern {
    private ImageFactory imageFactory = new ImageFactory();
    @Override
    public Shape getObject(String[] lineToParse, Scanner objects, HashMap<String, StrategyPattern> ObjectStrategy)
            throws ShapeException {
        Point center = new Point(Double.parseDouble(lineToParse[1]), Double.parseDouble(lineToParse[2]));
        Shape myShape = imageFactory.getImage(center,Double.parseDouble(lineToParse[3]),lineToParse[4]);
        return myShape;
    }
}
