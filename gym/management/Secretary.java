package gym.management;

import gym.Exception.*;
import gym.customers.*;
import gym.management.Sessions.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Secretary class responsible for managing client registrations,
 * instructor hiring, session creation, and other administrative tasks
 * in the gym management system.
 */
public class Secretary extends Person {
    private int salary;
    private boolean haveAccess = true;
    private Gym gym = Gym.getInstance();

    /**
     * Constructor for creating a Secretary instance.
     *
     * @param secretary Person object representing the secretary.
     * @param salary    Monthly salary for the secretary.
     */
    protected Secretary(Person secretary, int salary) {
        super(secretary);
        this.salary = salary;
        if (gym.getSecretary() != null)
            gym.getSecretary().haveAccess = false; // Revoking access from previous secretary if any

        gym.gymHistoryAdd("A new secretary has started working at the gym: " + secretary.getName());
    }

    /**
     * Registers a new client in the gym.
     *
     * @param person Person object representing the client.
     * @return Client object created after registration.
     * @throws InvalidAgeException      If client is under 18.
     * @throws DuplicateClientException If client is already registered.
     */
    public Client registerClient(Person person) throws InvalidAgeException, DuplicateClientException {
        haveAccess();
        Client newClient = Client.newClient(person);
        if (newClient.getAge() < 18) // Validate client's age
            throw new InvalidAgeException();
        if (gym.getClientsList().contains(person)) // Check for duplicate registration
            throw new DuplicateClientException();
        gym.addClient(newClient);
        gym.gymHistoryAdd("Registered new client: " + person.getName());
        return newClient;
    }

    /**
     * Unregisters an existing client from the gym.
     *
     * @param client Client object to be unregistered.
     * @throws ClientNotRegisteredException If client is not found in the gym's records.
     */
    public void unregisterClient(Client client) throws ClientNotRegisteredException {
        haveAccess();
        if (!gym.getClientsList().contains(client))
            throw new ClientNotRegisteredException();
        gym.getClientsList().remove(client);
        gym.gymHistoryAdd("Unregistered client: " + client.getName());
    }

    /**
     * Hires a new instructor for the gym.
     *
     * @param person        Person object representing the instructor.
     * @param hourlyWage    Hourly wage for the instructor.
     * @param validSessions List of sessions the instructor is qualified to lead.
     * @return Instructor object created after hiring.
     */
    public Instructor hireInstructor(Person person, int hourlyWage, ArrayList<SessionType> validSessions) {
        haveAccess();
        Instructor instructor = Instructor.newInstructor(person, hourlyWage, validSessions);
        gym.addInstructor(instructor);
        gym.gymHistoryAdd("Hired new instructor: " + person.getName() + " with salary per hour: " + hourlyWage);
        return instructor;
    }

    /**
     * Adds a new session to the gym's schedule.
     *
     * @param sessionType Type of session.
     * @param sessionTime Time of session.
     * @param forumType   Forum type of the session.
     * @param instructor  Instructor for the session.
     * @return Session object created.
     * @throws InstructorNotQualifiedException If instructor is not qualified for the session type.
     */
    public Session addSession(SessionType sessionType, String sessionTime, ForumType forumType, Instructor instructor) throws InstructorNotQualifiedException {
        haveAccess();

        // Validate instructor's qualifications
        if (!instructor.validSessions.contains(sessionType))
            throw new InstructorNotQualifiedException();
        Session session = SessionFactory.getSession(sessionType);
        session = session.newSession(sessionTime, forumType, instructor);
        gym.addSession(session);
        gym.gymHistoryAdd("Created new session: " + sessionType + " on " + CustomDate.customDate(sessionTime) + " with instructor: " + instructor.getName());
        return session;
    }

    /**
     * Registers a client to a specific session.
     *
     * @param client  Client to register.
     * @param session Session to register the client to.
     * @throws DuplicateClientException     If client is already registered.
     * @throws ClientNotRegisteredException If client is not in the gym's records.
     * @throws NullPointerException         If any required field is missing.
     */
    public void registerClientToLesson(Client client, Session session) throws DuplicateClientException, ClientNotRegisteredException, NullPointerException {
        haveAccess();
        if (!gym.getClientsList().contains(client))
            throw new ClientNotRegisteredException(1);

        boolean flag = true; // Tracks if registration can proceed
        if (futureDate.isDateInFuture(session.getTime())) {
            flag = false;
            gym.gymHistoryAdd("Failed registration: Session is not in the future");
        }

        // Validate client eligibility based on forum type
        if (!ForumTypeCheck.isType(client, session.getForum())) {
            flag = false;
            if (session.getForum() == ForumType.Seniors)
                gym.gymHistoryAdd("Failed registration: Client doesn't meet" +
                        " the age requirements for this session (Seniors)");
            else if (session.getForum() == ForumType.Female)
                gym.gymHistoryAdd("Failed registration: Client's gender " +
                        "doesn't match the session's gender requirements");
        }

        // Check for duplicate registration
        if (session.isRegistered(client)) {
            flag = false;
            throw new DuplicateClientException(1);
        }

        // Check if spots are available
        if (session.getPlaces() == 0) {
            flag = false;
            gym.gymHistoryAdd("Failed registration: No available spots for session");
        }

        // Check client's balance
        if (client.getBalance() < session.getPrice()) {
            flag = false;
            gym.gymHistoryAdd("Failed registration: Client doesn't have enough balance");
        }

        // Register the client
        if (flag) {
            client.reduceBalance(session.getPrice());
            gym.increaseBalance(session.getPrice());
            session.addClient(client);
            session.setPlaces();
            gym.gymHistoryAdd("Registered client: " + client.getName() + " to session: "
                    + session.getType() + " on " + CustomDate.customDate(session.getTime()) +
                    " for price: " + session.getPrice());
        }
    }

    /**
     * Sends notifications to clients registered for a specific session.
     *
     * @param session Session whose clients are to be notified.
     * @param message Message to send.
     */
    public void notify(Session session, String message) {
        haveAccess();
        List<Client> sessionClients = session.getClientList();
        NewsletterPublisher newsletterPublisher = new NewsletterPublisher();
        for (Client client : sessionClients)
            newsletterPublisher.register(client);
        newsletterPublisher.sendNewsletter(message);
        gym.gymHistoryAdd("A message was sent to everyone registered for session " + session.getType() + " on "
                + CustomDate.customDate(session.getTime()) + " : " + message);
    }

    /**
     * Sends a notification to all gym clients.
     *
     * @param message Message to send.
     */
    public void notify(String message) {
        haveAccess();
        NewsletterPublisher newsletterPublisher = new NewsletterPublisher();
        for (Client client : gym.getClientsList())
            newsletterPublisher.register(client);
        newsletterPublisher.sendNewsletter(message);
        gym.gymHistoryAdd("A message was sent to all gym clients: " + message);

    }

    /**
     * Sends notifications to all clients registered for sessions on a specific date.
     *
     * @param date    Date of sessions in format dd/MM/yyyy.
     * @param message Message to send.
     */
    public void notify(String date, String message) {
        haveAccess();
        NewsletterPublisher newsletterPublisher = new NewsletterPublisher();
        String time = "";
        for (Session session : gym.getSessionsList()) {
            time = session.getTime().substring(0, 10);
            if (time.equals(date))
                for (Client client : session.getClientList())
                    newsletterPublisher.register(client);
        }
        newsletterPublisher.sendNewsletter(message);
        String newDate = date.substring(6, 10) + "-" + date.substring(3, 5) + "-" + date.substring(0, 2);

        gym.gymHistoryAdd("A message was sent to everyone registered for a session on "
                + newDate + " : " + message);

    }

    /**
     * Pays salaries to all employees including the secretary and instructors.
     */
    public void paySalaries() {
        haveAccess();
        Secretary secretary = gym.getSecretary();
        gym.payForEmployees(secretary.getSalary());
        secretary.increaseBalance(gym.getSecretary().getSalary());

        for (Session session : gym.getSessionsList()) {
            Instructor instructor = session.getInstructor();
            gym.payForEmployees(instructor.getSalary());
            instructor.increaseBalance(instructor.getSalary());
        }
        gym.gymHistoryAdd("Salaries have been paid to all employees");
    }

    /**
     * Retrieves the monthly salary of the secretary.
     *
     * @return Salary amount.
     */
    private int getSalary() {
        haveAccess();
        return salary;
    }

    /**
     * Checks if the secretary has access to perform an action.
     *
     * @throws NullPointerException If access is not granted.
     */
    private void haveAccess() throws NullPointerException {
        if (!this.haveAccess)
            throw new NullPointerException();
    }

    /**
     * Prints all actions recorded in the gym's history.
     */
    public void printActions() {
        haveAccess();
        for (String s : gym.getGymHistory())
            System.out.println(s);
    }

    /**
     * Returns a string representation of the Secretary object.
     *
     * @return String representation of the secretary.
     */
    public String toString() {
        haveAccess();
        return "ID: " + this.getID() + " | Name: "
                + this.getName() + " | Gender: " + this.getGender() +
                " | Birthday: " + this.getbDay() + " | Age: " + this.getAge() +
                " | Balance: " + this.getBalance() + " | Role: Secretary | Salary per Month: "
                + this.getSalary();
    }
}
