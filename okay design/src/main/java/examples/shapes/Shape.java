package examples.shapes;

/**
 *  Shape
 *
 *  This represents an arbitrary shape. All shape types inherit from this abstract class.
 */
public abstract class Shape{

    private Point center;

    /**
     *
     * @param point center of our shape
     * @throws ShapeException throws exception if the position is invalid
     */
    public Shape(Point point) throws ShapeException {
        if( point == null)
            throw new ShapeException("Invalid center point");
        center = point;
    }
    /**
     * Move the Shape
     * @param deltaX            a delta change for the x-location of center of the circle
     * @param deltaY            a delta change for the y-location of center of the circle
     * @throws ShapeException   Exception thrown if either the delta x or y are not valid doubles
     */

    public void move(double deltaX, double deltaY) throws ShapeException {
        center.move(deltaX, deltaY);
    }

    /**
     *
     * @return the center of our shape
     */
    public Point getCenter() {
        return center;
    }

    /**
     *
     * @param center the center that we are setting for the shape
     */
    public void setCenter(Point center) throws ShapeException{
        if(center == null)
            throw new ShapeException("Invalid center");
        this.center = center;
    }
}
