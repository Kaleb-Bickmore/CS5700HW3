package examples.shapes;

/**
 *  Square
 *
 *  This represents a square class that extends on the shape class.
 */
public class Square extends Shape {
    private Double size;
    private Point [] vertices;
    /**
     *
     * @param center center of our square
     * @param size size of our square
     * @throws ShapeException throws exception if the size of the square is invalid
     */
    public Square(Point center, double size) throws ShapeException{
        super(center);
        Validator.validatePositiveDouble(size,"Invalid size");
        this.size = size;
        Point point1 = new Point(center.getX()-(size/2),center.getY()-(size/2));
        Point point2 = new Point(center.getX()-(size/2),center.getY()+(size/2));
        Point point3 = new Point(center.getX()+(size/2),center.getY()+(size/2));
        Point point4 = new Point(center.getX()+(size/2),center.getY()-(size/2));
        Point[] allVertices={point1,point2,point3,point4};
        this.vertices=allVertices;
    }

    /**
     *
     * @param x x coordinate of our square
     * @param y y coordinate of our square
     * @param size size of our square
     * @throws ShapeException throws exception if the size of the square is invalid
     */
    public Square(double x, double y, double size) throws ShapeException{
        super(new Point(x, y));
        Point center = new Point(x,y);
        Validator.validatePositiveDouble(size,"Invalid size");
        this.size = size;
        Point point1 = new Point(center.getX()-(size/2),center.getY()-(size/2));
        Point point2 = new Point(center.getX()-(size/2),center.getY()+(size/2));
        Point point3 = new Point(center.getX()+(size/2),center.getY()+(size/2));
        Point point4 = new Point(center.getX()+(size/2),center.getY()-(size/2));
        Point[] allVertices={point1,point2,point3,point4};
        this.vertices=allVertices;
    }

    /**
     *
     * @return Area of our square
     */
    public double getArea(){return size*size;}

    /**
     *
     * @return size of our square
     */
    public double getSize() {
        return size;
    }

    /**
     *
     * @param size The size that we will set for the square
     * @throws ShapeException throws exception if the size is invalid
     */
    public void setSize(double size)throws ShapeException {
        Validator.validatePositiveDouble(size, "Invalid size");
        this.size = size;
    }
    public void setCenter(Point center)throws ShapeException{
        if (center == null) {
            throw new ShapeException("Invalid center");
        } else {
            super.setCenter(center);
            Point point1 = new Point(center.getX() - (size / 2), center.getY() - (size / 2));
            Point point2 = new Point(center.getX() - (size / 2), center.getY() + (size / 2));
            Point point3 = new Point(center.getX() + (size / 2), center.getY() + (size / 2));
            Point point4 = new Point(center.getX() + (size / 2), center.getY() - (size / 2));
            Point[] allVertices = {point1, point2, point3, point4};
            this.vertices = allVertices;
        }
    }
    /**
     *
     * @return vertices of the square
     */
    public Point[] getVertices(){return vertices;}

    /**
     *
     * @param deltaX            a delta change for the x-location of the square
     * @param deltaY            a delta change for the y-location of the square
     * @throws ShapeException
     */
    public void move(double deltaX,double deltaY)throws ShapeException{
        this.setCenter(new Point(this.getCenter().getX()+deltaX,this.getCenter().getY()+deltaY));

    }
}
