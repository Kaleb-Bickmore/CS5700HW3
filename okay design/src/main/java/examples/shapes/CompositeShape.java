package examples.shapes;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class CompositeShape implements Shape {
    ArrayList<Shape> ShapeList;
    Point center;
    CompositeShape(Point center)throws ShapeException{
        if (center == null)
            throw new ShapeException("Invalid center");
        this.center = center;
        this.ShapeList = new ArrayList<Shape>();

    }
    @Override
    public void add(Shape myShape) {
        ShapeList.add(myShape);
    }

    @Override
    public void delete(Shape myShape) {
        ShapeList.remove(myShape);
    }

    @Override
    public double getArea() {
        double area = 0;
        for(Shape myShapes:ShapeList){
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
        for(Shape myShapes:ShapeList){
            myShapes.move(deltaX, deltaY);
        }

    }

    @Override
    public Point getCenter() {
        return this.center;
    }

    @Override
    public void setCenter(Point center) throws ShapeException {
        if (center == null)
            throw new ShapeException("Invalid center");
        this.center = center;
        for(Shape myShapes:ShapeList){
            myShapes.setCenter(center);
        }
    }

    @Override
    public void save(File fileLocation) throws IOException {
        //TODO add composite shape string to save

        FileWriter fw = new FileWriter(fileLocation.getPath(),fileLocation.exists());
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("composite,"+this.center.getX()+","+this.center.getY()+","+this.ShapeList.size());
        pw.close();
        for(Shape myShapes:ShapeList){
            myShapes.save(fileLocation);
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
        for(Shape myShapes:ShapeList){
            try{
                double deltaX = this.center.getX() + myShapes.getCenter().getX();
                double deltaY = this.center.getY() + myShapes.getCenter().getY();
                myShapes.move(deltaX,deltaY);
                myShapes.draw(G);
                myShapes.move(-deltaX,-deltaY);
            }catch (ShapeException e){
                e.getMessage();
            }
        }

    }
}
