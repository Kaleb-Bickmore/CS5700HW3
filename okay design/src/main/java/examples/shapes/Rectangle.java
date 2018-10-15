package examples.shapes;

/**
 *  Rectangle
 *
 *  This class represents a rectangle. This class expands on the square class and implements new methods.
 */
public class Rectangle extends Shape {
    private double height;
    private double width;
    private Point[] vertices;

    /**
     *
     * @param center center position of the rectangle
     * @param height height of the rectangle
     * @param width width of the rectangle
     * @throws ShapeException throws exception if either height or width are invalid
     */
    public Rectangle(Point center,double height, double width)throws ShapeException{
        super(center);
        Validator.validatePositiveDouble(width,"Invalid width");
        this.width=width;
        this.height=height;
        Point point1 = new Point(center.getX()-(width/2),center.getY()-(height/2));
        Point point2 = new Point(center.getX()-(width/2),center.getY()+(height/2));
        Point point3 = new Point(center.getX()+(width/2),center.getY()+(height/2));
        Point point4 = new Point(center.getX()+(width/2),center.getY()-(height/2));
        Point[] allVertices={point1,point2,point3,point4};
        this.vertices=allVertices;
    }

    /**
     *
     * @param x x coordinate of the recctangle's position
     * @param y y coordinate of the recctangle's position
     * @param height height of the rectangle
     * @param width width of the rectangle
     * @throws ShapeException throws exception if either height or width are invalid
     */
    public Rectangle(double x, double y,double height, double width)throws ShapeException{
        super(new Point(x,y));
        Point center = new Point(x,y);
        Validator.validatePositiveDouble(width,"Invalid width");
        this.width=width;
        Point point1 = new Point(center.getX()+(width/2),center.getY()+(height/2));
        Point point2 = new Point(center.getX()+(width/2),center.getY()-(height/2));
        Point point3 = new Point(center.getX()-(width/2),center.getY()-(height/2));
        Point point4 = new Point(center.getX()-(width/2),center.getY()+(height/2));
        Point[] allVertices={point1,point2,point3,point4};
        this.vertices=allVertices;
    }

    /**
     *
     * @return area of the rectangle
     */
    public double getArea(){return width*height;}

    /**
     *
     * @return width of the rectangleset
     */
    public double getWidth() {

        return this.width;
    }

    /**
     *
     * @param width Some positive number that is what we will set the width of the rectangle to.
     * @throws ShapeException throws exception if the width is invalid
     */
    public void setWidth(double width) throws ShapeException {
        Validator.validatePositiveDouble(width, "Invalid width");
        this.width = width;

    }

    /**
     *
     * @param height height of the rectangle
     * @param width width of the rectangle
     * @throws ShapeException throws exception if either height or width are invalid
     */
    public void setSize(double height, double width) throws ShapeException{
        Validator.validatePositiveDouble(height,"Invalid height");
        Validator.validatePositiveDouble(width,"Invalid width");
        this.width = width;
        this.height=height;
    }


    /**
     *
     * @return height of our square
     */
    public double getHeight() {
        return height;
    }

    /**
     *
     * @param height The height that we will set for the square
     * @throws ShapeException throws exception if the height is invalid
     */
    public void setHeight(double height)throws ShapeException {
        Validator.validatePositiveDouble(height, "Invalid height");
        this.height = height;
    }

    /**
     *
     * @throws ShapeException
     */
    public void setCenter(Point center)throws ShapeException{
        if (center == null)
            throw new ShapeException("Invalid center");
        super.setCenter(center);
        Point point1 = new Point(center.getX()-(width/2),center.getY()-(height/2));
        Point point2 = new Point(center.getX()-(width/2),center.getY()+(height/2));
        Point point3 = new Point(center.getX()+(width/2),center.getY()+(height/2));
        Point point4 = new Point(center.getX()+(width/2),center.getY()-(height/2));
        Point[] allVertices={point1,point2,point3,point4};
        this.vertices=allVertices;
    }
    /**
     *
     * @return vertices of our rectangle
     */

    public Point[] getVertices(){return vertices;}
    /**
     *
     * @param deltaX            a delta change for the x-location of the rectangle
     * @param deltaY            a delta change for the y-location of the rectangle
     * @throws ShapeException
     */
    public void move(double deltaX,double deltaY)throws ShapeException{
        this.setCenter(new Point(this.getCenter().getX()+deltaX,this.getCenter().getY()+deltaY));

    }

}
