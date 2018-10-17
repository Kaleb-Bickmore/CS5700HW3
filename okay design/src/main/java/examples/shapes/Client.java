package examples.shapes;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Parsing class for reading files from a scanner object;
 * We can either load an object or pass an inputStream of some sort to a scanner.
 * From here our client can save or draw all the shapes loaded in.
 */
public class Client {
    private ImageFactory imageFactory;
    private ArrayList<Shape> allShapes;
    //TODO add hashmap and implement strategy pattern
    Client(Scanner objects)throws ShapeException{
        this.allShapes = new ArrayList<Shape>();
        this.imageFactory = new ImageFactory();
        this.parse(objects);
    }

    /**
     *
     * @param objects scanner that is given by loading a script
     * @throws ShapeException
     */
    private void parse(Scanner objects) throws ShapeException {
        while (objects.hasNextLine()) {
            Shape myShape = null;
            String[] lineToParse = objects.nextLine().split(",");
            myShape = getShape(lineToParse,objects);
            if (myShape == null) {
                throw new ShapeException("error occurred in parsing");
            }
            this.allShapes.add(myShape);
        }
    }

    /**
     *
     * @param fileLoc fileLocation that we will persist our shapes to
     */
    public void saveAll(File fileLoc) throws IOException {
        for(Shape myShape:this.allShapes){
            myShape.save(fileLoc);
        }
    }

    /**
     *
     * @param G the graphics that we will draw to
     */
    public void draw(Graphics G){
        for(Shape myShape:this.allShapes){
            myShape.draw(G);
        }
    }
    /**
     *
     * @param lineToParse the current line we are at in our scanner
     * @param objects the scanner itself, in case we run into a composite
     * @return Shape object that we will throw in our arraylist of shape objects
     * @throws ShapeException
     */
    private Shape getShape(String[] lineToParse,Scanner objects) throws ShapeException {
        Shape myShape = null;
        if(lineToParse[0].toLowerCase().equals("composite")){
            Point center = new Point(Double.parseDouble(lineToParse[1]), Double.parseDouble(lineToParse[2]));
            int numLines = Integer.parseInt(lineToParse[3]);
            myShape = new CompositeShape(center);
            for (int i = 0; i < numLines; i++) {
                lineToParse = objects.nextLine().split(",");
                Shape newShape = getShape(lineToParse,objects);
                myShape.add(newShape);
            }
        }
        else if (lineToParse[0].toLowerCase().equals("square")) {
            Point center = new Point (Double.parseDouble(lineToParse[1]),Double.parseDouble(lineToParse[2]));
            myShape = new Square(center,Double.parseDouble(lineToParse[3]));
        }
        else if (lineToParse[0].toLowerCase().equals("rectangle")) {
            Point center = new Point (Double.parseDouble(lineToParse[1]),Double.parseDouble(lineToParse[2]));
            myShape = new Rectangle(center,Double.parseDouble(lineToParse[3]),Double.parseDouble(lineToParse[4]));
        }
        else if (lineToParse[0].toLowerCase().equals("triangle")) {
            Point point1 = new Point(Double.parseDouble(lineToParse[1]),Double.parseDouble(lineToParse[2]));
            Point point2 = new Point(Double.parseDouble(lineToParse[3]),Double.parseDouble(lineToParse[4]));
            Point point3 = new Point(Double.parseDouble(lineToParse[5]),Double.parseDouble(lineToParse[6]));
            myShape = new Triangle(point1,point2,point3);
        }
        else if (lineToParse[0].toLowerCase().equals("circle")) {
            Point center = new Point(Double.parseDouble(lineToParse[1]), Double.parseDouble(lineToParse[2]));
            myShape = new Circle(center,Double.parseDouble(lineToParse[3]));
        }

        else if (lineToParse[0].toLowerCase().equals("ellipse") ) {
            Point center = new Point(Double.parseDouble(lineToParse[1]), Double.parseDouble(lineToParse[2]));
            myShape = new Ellipse(center,Double.parseDouble(lineToParse[3]), Double.parseDouble(lineToParse[4]));
        }
        else if (lineToParse[0].toLowerCase().equals("embeddedimage") ) {
            Point center = new Point(Double.parseDouble(lineToParse[1]), Double.parseDouble(lineToParse[2]));
            myShape = imageFactory.getImage(center,Double.parseDouble(lineToParse[3]),lineToParse[4]);
        }
        else {
            Point point1 = new Point(Double.parseDouble(lineToParse[1]),Double.parseDouble(lineToParse[2]));
            Point point2 = new Point(Double.parseDouble(lineToParse[3]),Double.parseDouble(lineToParse[4]));
            myShape = new Line(point1,point2);
        }
        return myShape;
    }

}