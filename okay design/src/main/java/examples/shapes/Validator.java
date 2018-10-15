package examples.shapes;

public class Validator {
    public static void validateDouble(double value, String errorMessage) throws ShapeException {
        if (Double.isInfinite(value) || Double.isNaN(value))
            throw new ShapeException(errorMessage);
    }

    public static void validatePositiveDouble(double value, String errorMessage) throws ShapeException {
        validateDouble(value, errorMessage);
        if (value<0)
            throw new ShapeException(errorMessage);
    }
    public static void validateTriangle(Point point1, Point point2, Point point3, String errorMessage)//...
            throws ShapeException{
        Line line1= new Line(point1,point2);
        Line line2= new Line(point1,point3);
        Line line3= new Line(point2,point3);
        //if the two lines slope are the same
        if(Math.abs(line1.computeSlope())==Math.abs(line2.computeSlope())){
            throw new ShapeException(errorMessage);
        }
    }
}
