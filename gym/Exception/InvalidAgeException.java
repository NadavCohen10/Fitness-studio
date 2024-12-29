package gym.Exception;

/**
 * Custom exception class to handle scenarios where a client attempts
 * to register but does not meet the minimum age requirement.
 */
public class InvalidAgeException extends Exception {

    /**
     * Default constructor that initializes the exception with a specific message
     * indicating the age restriction for registration.
     */
    public InvalidAgeException() {
        super("Error: Client must be at least 18 years old to register");
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
