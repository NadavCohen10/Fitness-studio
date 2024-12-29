package gym.management.Sessions;

import gym.customers.Client;
import gym.management.ForumType;
import gym.management.Instructor;

import java.util.List;

/**
 * Represents a generic session in the gym system.
 * Provides a blueprint for implementing various session types.
 */
public interface Session {

    /**
     * Creates a new session.
     *
     * @param sessionTime the time of the session as a formatted string.
     * @param forumType   the forum type for the session.
     * @param instructor  the instructor conducting the session.
     * @return a new session instance.
     */
    Session newSession(String sessionTime, ForumType forumType, Instructor instructor);

    /**
     * Retrieves the price of the session.
     *
     * @return the price of the session.
     */
    int getPrice();

    /**
     * Retrieves the number of available places in the session.
     *
     * @return the number of available spots.
     */
    int getPlaces();

    /**
     * Retrieves the scheduled time of the session.
     *
     * @return the session time as a formatted string.
     */
    String getTime();

    /**
     * Retrieves the type of the session.
     *
     * @return the session type.
     */
    SessionType getType();

    /**
     * Retrieves the forum type of the session.
     *
     * @return the forum type.
     */
    ForumType getForum();

    /**
     * Updates the number of available places in the session.
     */
    void setPlaces();

    /**
     * Registers a client for the session.
     *
     * @param client the client to be added to the session.
     */
    void addClient(Client client);

    /**
     * Checks if a client is already registered for the session.
     *
     * @param client the client to be checked.
     * @return true if the client is registered, false otherwise.
     */
    boolean isRegistered(Client client);

    /**
     * Retrieves the list of clients registered for the session.
     *
     * @return a list of registered clients.
     */
    public List<Client> getClientList();

    /**
     * Retrieves the instructor conducting the session.
     *
     * @return the session's instructor.
     */
    public Instructor getInstructor();

    /**
     * Provides a string representation of the session.
     *
     * @return a string describing the session details.
     */
    public String toString();

}
