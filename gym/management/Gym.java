package gym.management;

import gym.customers.Client;
import gym.customers.Person;
import gym.management.Sessions.Session;

import java.util.LinkedList;
import java.util.List;

/**
 * Singleton class representing a Gym. This class manages the gym's clients,
 * instructors, sessions, financial balance, and history of actions performed.
 */
public class Gym {
    // Static instance of the Gym class to ensure singleton pattern
    private static Gym gym;

    // Attributes of the Gym class
    private Secretary secretary;
    private List<Client> clientsList = new LinkedList<>();
    private List<Instructor> instructorsList = new LinkedList<>();
    private List<Session> sessionsList = new LinkedList<>();
    private List<String> gymHistory = new LinkedList<>();
    private String gymName;
    private int balance;

    /**
     * Retrieves the singleton instance of the Gym class.
     *
     * @return the singleton Gym instance.
     */
    public static Gym getInstance() {
        if (gym == null) {
            gym = new Gym();
        }
        return gym;
    }

    /**
     * Adds a new client to the gym.
     *
     * @param client the Client object to be added.
     */
    protected void addClient(Client client) {
        clientsList.add(client);
    }

    /**
     * Retrieves the list of clients registered in the gym.
     *
     * @return a List of Client objects.
     */
    protected List<Client> getClientsList() {
        return clientsList;
    }

    /**
     * Adds a new instructor to the gym.
     *
     * @param instructor the Instructor object to be added.
     */
    protected void addInstructor(Instructor instructor) {
        instructorsList.add(instructor);
    }

    /**
     * Adds a new session to the gym.
     *
     * @param session the Session object to be added.
     */
    protected void addSession(Session session) {
        sessionsList.add(session);
    }

    /**
     * Retrieves the list of sessions offered by the gym.
     *
     * @return a List of Session objects.
     */
    protected List<Session> getSessionsList() {
        return sessionsList;
    }

    /**
     * Retrieves the history of actions performed in the gym.
     *
     * @return a List of Strings containing the history entries.
     */
    protected List<String> getGymHistory() {
        return gymHistory;
    }

    /**
     * Adds an entry to the gym's history log.
     *
     * @param string the history entry to be added.
     */
    protected void gymHistoryAdd(String string) {
        gymHistory.add(string);
    }

    /**
     * Sets the name of the gym.
     *
     * @param gymName the name to set for the gym.
     */
    public void setName(String gymName) {
        this.gymName = gymName;
    }

    /**
     * Assigns a Secretary to the gym with a specified salary.
     *
     * @param secretary the Person object to be assigned as Secretary.
     * @param salary    the monthly salary for the Secretary.
     */
    public void setSecretary(Person secretary, int salary) {
        this.secretary = new Secretary(secretary, salary);
    }

    /**
     * Retrieves the Secretary of the gym.
     *
     * @return the Secretary object.
     */
    public Secretary getSecretary() {
        return this.secretary;
    }

    /**
     * Increases the gym's financial balance.
     *
     * @param paying the amount to add to the balance.
     */
    protected void increaseBalance(int paying) {
        balance += paying;
    }

    /**
     * Deducts payments for employees from the gym's financial balance.
     *
     * @param paying the amount to deduct.
     */
    protected void payForEmployees(int paying) {
        balance -= paying;
    }

    /**
     * Retrieves the current balance of the gym.
     *
     * @return the gym's financial balance.
     */
    private int getBalance() {
        return balance;
    }

    /**
     * Prints the details of the gym, including its name, secretary, balance,
     * clients, employees, and sessions.
     *
     * @return an empty String as the formatted data is directly printed.
     */
    public String toString() {
        System.out.println("Gym Name: " + gymName);
        System.out.println("Gym Secretary: " + getSecretary());
        System.out.println("Gym Balance: " + getBalance());

        System.out.println("\nClients Data:");
        for (Client client : clientsList) {
            System.out.println(client);
        }

        System.out.println("\nEmployees Data:");
        for (Instructor instructor : instructorsList) {
            System.out.println(instructor);
        }
        System.out.println(getSecretary());

        System.out.println("\nSessions Data:");
        for (Session session : sessionsList) {
            System.out.print(session);
            if (!session.equals(sessionsList.getLast()))
                System.out.println();
        }
        return "";
    }
}
