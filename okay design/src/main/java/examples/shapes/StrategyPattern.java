package examples.shapes;

import java.util.HashMap;
import java.util.Scanner;

public interface StrategyPattern {
    public Shape getObject(String[] lineToParse, Scanner objects,
                           HashMap<String, StrategyPattern> ObjectStrategy) throws ShapeException;
}
