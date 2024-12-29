package gym.management.Sessions;

import gym.customers.Client;
import gym.management.ForumType;
import gym.management.Instructor;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a Machine Pilates session in the gym.
 * This class implements the Session interface, encapsulating the details of a specific session type.
 */
public class ThaiBoxing implements Session {
    protected List<Client> clientsList = new LinkedList<>();
    final private int PRICE = 100;
    final private int AVAILABLE_PLACE = 20;
    private int registerCount = 0;
    private SessionType SESSION_TYPE = SessionType.ThaiBoxing;
    private String sessionTime;
    private ForumType forumType;
    private Instructor instructor;

    /**
     * Default constructor for creating a Thai Boxing session instance.
     * This constructor is protected and is not intended for direct use.
     */
    protected ThaiBoxing() {
    }

    /**
     * Private constructor to initialize a Thai Boxing session with specific details.
     *
     * @param sessionTime the time of the session.
     * @param forumType   the forum type for the session.
     * @param instructor  the instructor conducting the session.
     */
    private ThaiBoxing(String sessionTime, ForumType forumType, Instructor instructor) {
        this.sessionTime = sessionTime;
        this.forumType = forumType;
        this.instructor = instructor;
    }

    /**
     * Creates a new Thai Boxing session with the provided details.
     *
     * @param sessionTime the time of the session.
     * @param forumType   the forum type for the session.
     * @param instructor  the instructor conducting the session.
     * @return a new Thai Boxing session instance.
     */
    @Override
    public ThaiBoxing newSession(String sessionTime, ForumType forumType, Instructor instructor) {
        return new ThaiBoxing(sessionTime, forumType, instructor);
    }

    /**
     * Returns the price of the session.
     *
     * @return the price of the Thai Boxing session.
     */
    @Override
    public int getPrice() {
        return PRICE;
    }

    /**
     * Returns the number of available places for registration.
     *
     * @return the number of available places in the session.
     */
    @Override
    public int getPlaces() {
        return AVAILABLE_PLACE - registerCount;
    }

    /**
     * Returns the time at which the session takes place.
     *
     * @return the session time.
     */
    @Override
    public String getTime() {
        return sessionTime;
    }

    /**
     * Returns the type of the session, in this case, Thai Boxing.
     *
     * @return the session type (Thai Boxing).
     */
    @Override
    public SessionType getType() {
        return SESSION_TYPE;
    }

    /**
     * Returns the forum type for the session.
     *
     * @return the forum type.
     */
    @Override
    public ForumType getForum() {
        return forumType;
    }

    /**
     * Registers a client for the session, increasing the count of registered clients.
     * This method ensures that the registration count does not exceed the available places.
     */
    @Override
    public void setPlaces() {
        if (registerCount < AVAILABLE_PLACE)
            registerCount++;
    }

    /**
     * Adds a client to the list of participants for this session.
     *
     * @param client the client to be added.
     */
    public void addClient(Client client) {
        clientsList.add(client);
    }

    /**
     * Checks if a client is already registered for the session.
     *
     * @param client the client to check.
     * @return true if the client is registered, false otherwise.
     */
    public boolean isRegistered(Client client) {
        return clientsList.contains(client);
    }

    /**
     * Returns the list of clients registered for this session.
     *
     * @return the list of clients registered for the session.
     */
    public List<Client> getClientList() {
        return clientsList;
    }

    /**
     * Returns the instructor of the session.
     *
     * @return the instructor conducting the session.
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * Returns a string representation of the Thai Boxing session, including the session type, time, forum type,
     * instructor, and number of registered participants.
     *
     * @return a string describing the session details.
     */
    public String toString() {
        return "Session Type: " + this.getType() + " | Date: " + this.getTime() +
                " | Forum: " + this.getForum() + " | Instructor: " + this.getInstructor().getName() +
                " | Participants: " + this.registerCount + "/" + this.AVAILABLE_PLACE;
    }
}