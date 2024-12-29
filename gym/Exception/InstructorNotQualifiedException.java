package gym.Exception;

/**
 * Custom exception class to handle scenarios where an instructor attempts
 * to conduct a session type for which they are not qualified.
 */
public class InstructorNotQualifiedException extends Exception {

    /**
     * Default constructor that initializes the exception with a specific message
     * indicating that the instructor is not qualified to conduct the session.
     */
    public InstructorNotQualifiedException() {
        super("Error: Instructor is not qualified to conduct this session type.");
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
