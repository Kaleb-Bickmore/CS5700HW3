package examples.shapes;

import java.util.HashMap;
import java.util.Scanner;

public class SquarePattern implements StrategyPattern {

    @Override
    public Shape getObject(String[] lineToParse, Scanner objects, HashMap<String, StrategyPattern> ObjectStrategy)
            throws ShapeException {
        Point center = new Point (Double.parseDouble(lineToParse[1]),Double.parseDouble(lineToParse[2]));
        Shape myShape = new Square(center,Double.parseDouble(lineToParse[3]));
        return myShape;
    }
}
