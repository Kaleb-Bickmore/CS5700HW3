package examples.shapes;

import java.util.Scanner;

public interface StrategyPattern {
    public Shape getObject(String[] lineToParse, Scanner objects);
}
