package examples.shapes;

import java.awt.*;
import java.io.*;

/**
 *  Ellipse
 *
 *  This class represents an ellipse. It expands on methods created in the Circle class. It also adds new Methods.
 */
public class Ellipse extends Circle {
    private double yAxisRadius;

    /**
     *
     * @param center        The point that is the center of the ellipse
     * @param xAxisRadius   xAxis radius of the ellipse
     * @param yAxisRadius   yAxis radius of the ellipse
     * @throws ShapeException throws exception if y axis radius is invalid
     */
    public Ellipse(Point center,  double xAxisRadius, double yAxisRadius) throws ShapeException {
        super(center,xAxisRadius);
        Validator.validatePositiveDouble(yAxisRadius, "Invalid yAxisRadius");
        this.yAxisRadius = yAxisRadius;
    }

    /**
     *
     * @return the yAxis radius of the ellipse
     */
    public double getYAxisRadius() {
        return yAxisRadius;
    }

    /**
     *
     * @param yAxisRadius       YAxis radius of the ellipse that we will set
     * @throws ShapeException   throws exception if the yAxis radius is invalid
     */
    public void setYAxisRadius(double yAxisRadius) throws ShapeException {
        Validator.validatePositiveDouble(yAxisRadius,"Invalid yAxisRadius");
        this.yAxisRadius = yAxisRadius;
    }

    /**
     *
     * @param xAxisRadius       xAxis radius of the ellipse that we will set
     * @param yAxisRadius       yAxis radius of the ellipse that we will set
     * @throws ShapeException   throws an error if either radius is invalid
     */
    public void setAllRadius(double xAxisRadius, double yAxisRadius) throws ShapeException{
        Validator.validatePositiveDouble(yAxisRadius, "Invalid yAxisRadius");
        this.yAxisRadius = yAxisRadius;
        this.setXAxisRadius(xAxisRadius);
    }

    /**
     * scales both the xAxis and yAxis radius by some non-negative integer
     * @param scaleFactor       a non-negative double that represents the percentage to scale the circle.
     *                          0>= and <1 to shrink.
     *                          >1 to grow.
     * @throws ShapeException   throws exception if scaleFactor is invalid
     */
    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        this.setXAxisRadius(this.getXAxisRadius()*scaleFactor);
        this.yAxisRadius *= scaleFactor;
    }

    /**
     * @return  The area of the ellipse.
     */
    public double computeArea() {
        return Math.PI * this.getXAxisRadius() * this.yAxisRadius;
    }

    public void save(File fileLocation) throws IOException {
        FileWriter fw = new FileWriter(fileLocation.getPath(),fileLocation.exists());
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        pw.println("ellipse,"+this.center.getX()+","+this.center.getY()+","+super.getXAxisRadius()+","+this.yAxisRadius);
        pw.close();

    }
    @Override
    public void draw(Graphics G){
        G.drawOval((int)this.center.getX(),(int)this.center.getY(),
                (int)(this.getXAxisRadius()*2), (int)(this.getYAxisRadius()*2));

    }
}