package gym.management.Sessions;

/**
 * Factory class to create instances of different session types.
 * This class provides a method to generate a session based on the provided session type.
 */
public class SessionFactory {

    /**
     * Returns a new session instance based on the provided session type.
     * The method checks the session type and creates the appropriate session instance.
     *
     * @param sessionType the type of session to be created.
     * @return a new session instance of the corresponding type or null if the session type is not recognized.
     */

    public static Session getSession(SessionType sessionType) {
        if (sessionType == null)
            return null;

        // Use a switch expression to return the appropriate session based on the sessionType
        return switch (sessionType.toString()) {
            case "Pilates" -> new Pilates();
            case "Ninja" -> new Ninja();
            case "MachinePilates" -> new MachinePilates();
            case "ThaiBoxing" -> new ThaiBoxing();
            default -> null;
        };
    }
}
