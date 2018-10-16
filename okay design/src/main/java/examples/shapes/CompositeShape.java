package examples.shapes;

import java.awt.*;
import java.util.ArrayList;

public class CompositeShape implements ShapeComponent {
    ArrayList<ShapeComponent> ShapeList;
    Point center;
    @Override
    public void add(ShapeComponent myShape) {
        ShapeList.add(myShape);
    }

    @Override
    public void delete(ShapeComponent myShape) {
        ShapeList.remove(myShape);
    }

    @Override
    public double getArea() {
        double area = 0;
        for(ShapeComponent myShapes:ShapeList){
            area+=myShapes.getArea();
        }
        return area;
    }

    /**
     * Moves the composite and all the shapes inside the composite
     * @param deltaX the change in the x direction
     * @param deltaY the change in the y direction
     * @throws ShapeException
     */
    @Override
    public void move(double deltaX, double deltaY) throws ShapeException{
        center.move(deltaX, deltaY);
        for(ShapeComponent myShapes:ShapeList){
            myShapes.move(deltaX, deltaY);
        }

    }

    /**
     * Removes all elements in our list of shapes inside the composite
     */
    @Override
    public void deleteAll() {
        ShapeList.removeAll(ShapeList);
    }

    @Override
    public void draw(Graphics G) {
        for(ShapeComponent myShapes:ShapeList){
            myShapes.draw(G);
        }

    }
}
