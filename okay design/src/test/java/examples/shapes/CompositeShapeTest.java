package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompositeShapeTest {
    @Test
    public void invalidConstructor() {
        try{
            CompositeShape myShape = new CompositeShape(null);
        } catch (ShapeException e) {
            assertEquals(e.getMessage(),"Invalid center");
        }
    }
    @Test
    public void add() throws ShapeException {
        Point center = new Point(1,2);
        CompositeShape myShape = new CompositeShape(center);
        myShape.add(new Circle(center,12));
        assertEquals(myShape,myShape);
    }

    @Test
    public void delete() throws ShapeException {
        Point center = new Point(1,2);
        CompositeShape myShape = new CompositeShape(center);
        Circle myCircle = new Circle(center,12);
        myShape.add(myCircle);
        myShape.delete(myCircle);
        assertEquals(myShape,myShape);

    }

    @Test
    public void getArea() throws ShapeException {
        Point center = new Point(1,2);
        CompositeShape myShape = new CompositeShape(center);
        Square mySquare = new Square(center,12);
        myShape.add(mySquare);
        myShape.add(mySquare);
        myShape.add(mySquare);
        assertEquals(myShape.getArea(),mySquare.getArea()*3,0);

    }

    @Test
    public void move() throws ShapeException {
        Point center = new Point(1,2);
        CompositeShape myShape = new CompositeShape(center);
        Square mySquare = new Square(center,12);
        myShape.move(1,1);
        assertEquals(myShape.getCenter().getX(),2,0);
        assertEquals(myShape.getCenter().getY(),3,0);

    }

    @Test
    public void getCenter() throws ShapeException {
        Point center = new Point(1,2);
        CompositeShape myShape = new CompositeShape(center);
        assertEquals(myShape.getCenter().getX(),1,0);
        assertEquals(myShape.getCenter().getY(),2,0);

    }

    @Test
    public void setCenter() throws ShapeException {
        Point center = new Point(1,2);
        CompositeShape myShape = new CompositeShape(center);
        center = new Point(6,6);
        myShape.setCenter(center);
        assertEquals(myShape.getCenter().getX(),6,0);
        assertEquals(myShape.getCenter().getY(),6,0);
    }

    @Test
    public void deleteAll() throws ShapeException {
        Point center = new Point(1,2);
        CompositeShape myShape = new CompositeShape(center);
        Square mySquare = new Square(center,2);
        myShape.add(mySquare);
        myShape.deleteAll();
        try{
            myShape.delete(mySquare);
        }catch (Exception e){
            assertEquals("shape not found",e.getMessage());
        }
    }

}