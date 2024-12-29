package gym.Exception;

/**
 * Custom exception class to handle scenarios where a duplicate client registration
 * attempt is made in the gym system.
 */
public class DuplicateClientException extends Exception {

    /**
     * Default constructor that initializes the exception with a specific message
     * indicating that the client is already registered in the gym system.
     */
    public DuplicateClientException() {
        super("Error: The client is already registered");
    }

    /**
     * Overloaded constructor that initializes the exception with a specific message
     * indicating that the client is already registered for a particular lesson.
     *
     * @param i an integer for overloading the method.
     */
    public DuplicateClientException(int i) {
        super("Error: The client is already registered for this lesson");
    }

    /**
     * Retrieves the exception message.
     *
     * @return the detailed exception message.
     */
    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
