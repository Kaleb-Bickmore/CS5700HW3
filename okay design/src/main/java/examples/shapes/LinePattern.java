package examples.shapes;

import java.util.HashMap;
import java.util.Scanner;

public class LinePattern implements StrategyPattern {
    @Override
    public Shape getObject(String[] lineToParse, Scanner objects, HashMap<String, StrategyPattern> ObjectStrategy)
            throws ShapeException {
        Point point1 = new Point(Double.parseDouble(lineToParse[1]),Double.parseDouble(lineToParse[2]));
        Point point2 = new Point(Double.parseDouble(lineToParse[3]),Double.parseDouble(lineToParse[4]));
        Shape myShape = new Line(point1,point2);
        return myShape;
    }
}
