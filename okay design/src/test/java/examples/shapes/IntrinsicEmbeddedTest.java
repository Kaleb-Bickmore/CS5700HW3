package examples.shapes;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class IntrinsicEmbeddedTest {

    @Test
    public void getArea() {
        IntrinsicEmbedded intrinsic = new IntrinsicEmbedded("somefile");
        try{
            intrinsic.getArea();
        }catch (UnsupportedOperationException e){
            assertNull(e.getMessage());
        }
    }

    @Test
    public void draw() {

        IntrinsicEmbedded intrinsic = new IntrinsicEmbedded("somefile");
        try{
            intrinsic.draw(null);
        }catch (UnsupportedOperationException e){
            assertNull(e.getMessage());
        }
    }

    @Test
    public void move() throws ShapeException {

        IntrinsicEmbedded intrinsic = new IntrinsicEmbedded("somefile");
        try{
            intrinsic.move(0,0);
        }catch (UnsupportedOperationException e){
            assertNull(e.getMessage());
        }
    }

    @Test
    public void getCenter() {
        IntrinsicEmbedded intrinsic = new IntrinsicEmbedded("somefile");
        try{
            intrinsic.getCenter();
        }catch (UnsupportedOperationException e){
            assertNull(e.getMessage());
        }

    }

    @Test
    public void setCenter() throws ShapeException {
        IntrinsicEmbedded intrinsic = new IntrinsicEmbedded("somefile");
        try{
            intrinsic.setCenter(new Point(0,0));
        }catch (UnsupportedOperationException e){
            assertNull(e.getMessage());
        }
    }

    @Test
    public void save() {

        IntrinsicEmbedded intrinsic = new IntrinsicEmbedded("somefile");
        try{
            intrinsic.save(new File("somefile"));
        }catch (UnsupportedOperationException e){
            assertNull(e.getMessage());
        }
    }

    @Test
    public void getImageLoc() {
        IntrinsicEmbedded intrinsic = new IntrinsicEmbedded("somefile");
        assertEquals(intrinsic.getImageLoc(),"somefile");
    }
}