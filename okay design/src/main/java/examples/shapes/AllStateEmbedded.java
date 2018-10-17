package examples.shapes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class AllStateEmbedded extends EmbeddedImage {
    private Point center;
    private double size;
    private Point[] vertices;
    IntrinsicEmbedded intrinsicState;
    AllStateEmbedded(IntrinsicEmbedded intrinsicState,Point center, double size) throws ShapeException{

        this.center = center;
        Validator.validatePositiveDouble(size,"Invalid size");
        this.size = size;
        Point point1 = new Point(center.getX()-(size/2),center.getY()-(size/2));
        Point point2 = new Point(center.getX()-(size/2),center.getY()+(size/2));
        Point point3 = new Point(center.getX()+(size/2),center.getY()+(size/2));
        Point point4 = new Point(center.getX()+(size/2),center.getY()-(size/2));
        Point[] allVertices={point1,point2,point3,point4};
        this.vertices=allVertices;
        this.intrinsicState =intrinsicState;
    }
    @Override
    public double getArea() {
        return size*size;
    }

    public void setCenter(Point center)throws ShapeException{
        if (center == null) {
            throw new ShapeException("Invalid center");
        } else {
            this.center = center;
            Point point1 = new Point(center.getX() - (size / 2), center.getY() - (size / 2));
            Point point2 = new Point(center.getX() - (size / 2), center.getY() + (size / 2));
            Point point3 = new Point(center.getX() + (size / 2), center.getY() + (size / 2));
            Point point4 = new Point(center.getX() + (size / 2), center.getY() - (size / 2));
            Point[] allVertices = {point1, point2, point3, point4};
            this.vertices = allVertices;
        }
    }

    @Override
    public void draw(Graphics G) {
        final BufferedImage image;
        File imageFile = new File(intrinsicState.getImageLoc().replace("\"",""));
        System.out.print(imageFile.getAbsolutePath());
        try {
            image = ImageIO.read(imageFile);
            G.drawImage(image,(int)this.center.getX(),(int)this.center.getY(),(int)this.size,(int)this.size,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void move(double deltaX, double deltaY) throws ShapeException {
        this.setCenter(new Point(this.getCenter().getX()+deltaX,this.getCenter().getY()+deltaY));
    }

    @Override
    public Point getCenter() {
        return this.center;
    }


    @Override
    public void save(File fileLocation) throws IOException {
        FileWriter fw = new FileWriter(fileLocation.getPath(),fileLocation.exists());
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("embeddedimage,"+this.center.getX()+","+this.center.getY()+","+
                this.size+","+this.intrinsicState.getImageLoc());
        pw.close();

    }
    public Point[] getVertices(){return vertices;}
    public double getSize() {
        return this.size;
    }

    public String getImageLoc(){
        return this.intrinsicState.getImageLoc();
    }
}
