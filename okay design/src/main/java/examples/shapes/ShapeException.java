package examples.shapes;

/**
 * ShapeException
 *
 * A specialization of exception that gets thrown by shapes when there if a runtime error of some kind
 */
@SuppressWarnings("WeakerAccess")
public class ShapeException extends Exception {
    /**
     * Create a default process exception
     */
    public ShapeException() { super(); }

    /**
     * Create a process exception with a specific message.
     *
     * @param message       A string contain a descriptive message about the exception
     */
    public ShapeException(String message) {
        super(message);
    }
}
