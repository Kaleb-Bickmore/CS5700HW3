package examples.shapes;

/**
 * Circle
 *
 * This class represents circle objects that can be moved and scales.  Users of a circle can also get its area.
 *
 */
@SuppressWarnings("WeakerAccess")
public class Circle extends Shape {

    private double xAxisRadius;

    /**
     * Constructor with x-y Location for center
     *
     * @param x                 The x-location of the center of the circle -- must be a valid double
     * @param y                 The y-location of the center of the circle
     * @param xAxisRadius       The xAxisRadius of the circle -- must be greater or equal to zero.
     * @throws ShapeException   The exception thrown if the x, y, or z are not valid
     */
    public Circle(double x, double y, double xAxisRadius) throws ShapeException {
        super(new Point(x,y));
        Validator.validatePositiveDouble(xAxisRadius, "Invalid xAxisRadius");
        this.xAxisRadius = xAxisRadius;
    }

    /**
     * Constructor with a Point for center
     *
     * @param center            The x-location of the center of the circle -- must be a valid point
     * @param xAxisRadius       The xAxisRadius of the circle -- must be greater or equal to zero.
     * @throws ShapeException   The exception thrown if the x, y, or z are not valid
     */
    public Circle(Point center, double xAxisRadius) throws ShapeException {
        super(center);
        Validator.validatePositiveDouble(xAxisRadius, "Invalid xAxisRadius");
        this.xAxisRadius = xAxisRadius;


        this.xAxisRadius = xAxisRadius;
    }

    /**
     * @return  The xAxisRadius of the circle
     */
    public double getXAxisRadius() { return xAxisRadius; }

    /**
     *
     * @param xAxisRadius this is a positive integer representing the radius of the circle
     * @throws ShapeException throws exception if radius is not valid
     */
    public void setXAxisRadius(double xAxisRadius) throws ShapeException {
        Validator.validatePositiveDouble(xAxisRadius, "Invalid xAxisRadius");
        this.xAxisRadius = xAxisRadius;
    }


    /**
     * Scale the circle
     *
     * @param scaleFactor       a non-negative double that represents the percentage to scale the circle.
     *                          0>= and <1 to shrink.
     *                          >1 to grow.
     * @throws ShapeException   Exception thrown if the scale factor is not valid
     */
    public void scale(double scaleFactor) throws ShapeException {
        Validator.validatePositiveDouble(scaleFactor, "Invalid scale factor");
        xAxisRadius *= scaleFactor;
    }

    /**
     * @return  The area of the circle.
     */
    public double computeArea() {
        return Math.PI * Math.pow(xAxisRadius, 2);
    }

}
