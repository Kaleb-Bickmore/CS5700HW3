package examples.shapes;

import java.util.HashMap;
import java.util.Scanner;

public class TrianglePattern implements StrategyPattern {
    @Override
    public Shape getObject(String[] lineToParse, Scanner objects, HashMap<String, StrategyPattern> ObjectStrategy)
            throws ShapeException {
        Point point1 = new Point(Double.parseDouble(lineToParse[1]),Double.parseDouble(lineToParse[2]));
        Point point2 = new Point(Double.parseDouble(lineToParse[3]),Double.parseDouble(lineToParse[4]));
        Point point3 = new Point(Double.parseDouble(lineToParse[5]),Double.parseDouble(lineToParse[6]));
        Shape myShape = new Triangle(point1,point2,point3);
        return myShape;
    }
}
