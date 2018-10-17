package examples.shapes;

import org.junit.Test;

import static org.junit.Assert.*;

public class AllStateEmbeddedTest {

    @Test
    public void getArea() throws ShapeException {
        IntrinsicEmbedded intrinsic = new IntrinsicEmbedded("someFile");
        Point center = new Point(1,2);
        Shape allState = new AllStateEmbedded(intrinsic,center,12);
        assertEquals(12*12,allState.getArea(),0);
    }

    @Test
    public void setCenter() throws ShapeException {
        IntrinsicEmbedded intrinsic = new IntrinsicEmbedded("someFile");
        Point center = new Point(1,2);
        Shape allState = new AllStateEmbedded(intrinsic,center,12);
        center = new Point(4,4);
        allState.setCenter(center);
        assertEquals(center.getX(),allState.getCenter().getX(),0);
        assertEquals(center.getY(),allState.getCenter().getY(),0);
        center = null;
        try{
            allState.setCenter(center);
        }catch (ShapeException e){
            assertEquals(e.getMessage(),"Invalid center");
        }
    }



    @Test
    public void move() throws ShapeException {
        IntrinsicEmbedded intrinsic = new IntrinsicEmbedded("someFile");
        Point center = new Point(2, 2);
        AllStateEmbedded allState = new AllStateEmbedded(intrinsic, center, 4);
        allState.move(1, 1);
        Point[] comparePoints = {new Point(1.0, 1.0), new Point(1.0, 5.0),
                new Point(5.0, 5.0), new Point(5.0, 1.0)};
        Point[] myVertices = allState.getVertices();
        for (int i = 0; i < myVertices.length; i++) {
            assertEquals(myVertices[i].getX(), comparePoints[i].getX(), 0.0);
            assertEquals(myVertices[i].getY(), comparePoints[i].getY(), 0.0);
        }
    }

    @Test
    public void getCenter() throws ShapeException {
        IntrinsicEmbedded intrinsic = new IntrinsicEmbedded("someFile");
        Point center = new Point(1,2);
        AllStateEmbedded allState = new AllStateEmbedded(intrinsic,center,12);
        assertEquals(allState.getCenter().getX(),center.getX(),0);
        assertEquals(allState.getCenter().getY(),center.getY(),0);
    }


    @Test
    public void getImageLoc() throws ShapeException {
        IntrinsicEmbedded intrinsic = new IntrinsicEmbedded("someFile");
        Point center = new Point(1,2);
        Shape allState = new AllStateEmbedded(intrinsic,center,12);
        assertEquals(((AllStateEmbedded) allState).getImageLoc(),intrinsic.getImageLoc());
    }

    @Test
    public void getSize() throws ShapeException {
        IntrinsicEmbedded intrinsic = new IntrinsicEmbedded("someFile");
        Point center = new Point(1,2);
        AllStateEmbedded allState = new AllStateEmbedded(intrinsic,center,12);
        assertEquals(allState.getSize(),12,0);
    }
}