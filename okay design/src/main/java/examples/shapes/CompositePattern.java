package examples.shapes;

import java.util.HashMap;
import java.util.Scanner;

public class CompositePattern implements StrategyPattern {
    @Override
    public Shape getObject(String[] lineToParse, Scanner objects,HashMap<String, StrategyPattern>objectStrategy) throws ShapeException {
        Point center = new Point(Double.parseDouble(lineToParse[1]), Double.parseDouble(lineToParse[2]));
        int numLines = Integer.parseInt(lineToParse[3]);
        Shape myShape = new CompositeShape(center);
        for (int i = 0; i < numLines; i++) {
            lineToParse = objects.nextLine().split(",");
            Shape newShape = objectStrategy.get(lineToParse[0]).getObject(lineToParse,objects,objectStrategy);
            myShape.add(newShape);
        }
        return myShape;
    }
}
