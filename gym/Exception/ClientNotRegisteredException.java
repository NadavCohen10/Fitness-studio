package gym.Exception;

/**
 * Custom exception class to handle scenarios where an action is attempted
 * on a client who is not registered in the gym system.
 */
public class ClientNotRegisteredException extends Exception {

    /**
     * Default constructor that initializes the exception with a specific message
     * indicating that registration is required before attempting to unregister.
     */
    public ClientNotRegisteredException() {
        super("Error: Registration is required before attempting to unregister");
    }

    /**
     * Overloaded constructor that initializes the exception with a specific message
     * indicating the client is not registered and cannot enroll in lessons.
     *
     * @param i an integer for overloading the method.
     */
    public ClientNotRegisteredException(int i) {
        super("Error: The client is not registered with the gym and cannot enroll in lessons");
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

