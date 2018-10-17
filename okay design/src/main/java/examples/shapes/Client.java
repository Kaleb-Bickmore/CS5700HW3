package examples.shapes;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Parsing class for reading files from a scanner object;
 * We can either load an object or pass an inputStream of some sort to a scanner.
 * From here our client can save or draw all the shapes loaded in.
 */
public class Client {
    private ArrayList<Shape> allShapes;
    private HashMap<String, StrategyPattern> objectStrategy;

    //TODO add hashmap and implement strategy pattern
    Client(Scanner objects) throws ShapeException {
        this.allShapes = new ArrayList<Shape>();
        objectStrategy = new HashMap<String, StrategyPattern>();
        objectStrategy.put("composite",new CompositePattern());
        objectStrategy.put("circle",new CirclePattern());
        objectStrategy.put("ellipse",new EllipsePattern());
        objectStrategy.put("embeddedimage",new EmbeddedPattern());
        objectStrategy.put("rectangle",new RectPattern());
        objectStrategy.put("square",new SquarePattern());
        objectStrategy.put("triangle",new TrianglePattern());
        objectStrategy.put("line",new LinePattern());
        this.parse(objects);

    }

    /**
     * @param objects scanner that is given by loading a script
     * @throws ShapeException
     */
    private void parse(Scanner objects) throws ShapeException {
        while (objects.hasNextLine()) {
            Shape myShape = null;
            String[] lineToParse = objects.nextLine().split(",");
            myShape = objectStrategy.get(lineToParse[0]).getObject(lineToParse, objects, objectStrategy);
            if (myShape == null) {
                throw new ShapeException("error occurred in parsing");
            }
            this.allShapes.add(myShape);
        }
    }

    /**
     * @param fileLoc fileLocation that we will persist our shapes to
     */
    public void saveAll(File fileLoc) throws IOException {
        for (Shape myShape : this.allShapes) {
            myShape.save(fileLoc);
        }
    }

    /**
     * @param G the graphics that we will draw to
     */
    public void draw(Graphics G) {
        for (Shape myShape : this.allShapes) {
            myShape.draw(G);
        }
    }


}