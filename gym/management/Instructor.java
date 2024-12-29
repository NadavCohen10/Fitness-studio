package gym.management;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import gym.customers.Person;
import gym.management.Sessions.SessionType;

/**
 * Represents an instructor in the gym system.
 * An instructor is a specialized person with a salary and a list of certified session types.
 */
public class Instructor extends Person {
    //List of session types the instructor is certified to teach.
    protected List<SessionType> validSessions = new LinkedList<>();
    protected int salary;

    /**
     * Private constructor for creating an Instructor instance.
     *
     * @param person        the person details for the instructor.
     * @param salary        the hourly salary of the instructor.
     * @param validSessions the list of session types the instructor is certified to teach.
     */
    private Instructor(Person person, int salary, ArrayList<SessionType> validSessions) {
        super(person);
        this.salary = salary;
        this.validSessions = validSessions;
    }

    /**
     * Factory method for creating a new instructor.
     *
     * @param person        the person details for the instructor.
     * @param salary        the hourly salary of the instructor.
     * @param validSessions the list of session types the instructor is certified to teach.
     * @return a new Instructor instance.
     */
    protected static Instructor newInstructor(Person person, int salary, ArrayList<SessionType> validSessions) {
        return new Instructor(person, salary, validSessions);
    }

    /**
     * Retrieves the salary of the instructor.
     *
     * @return the hourly salary of the instructor.
     */
    protected int getSalary() {
        return salary;
    }

    /**
     * Provides a string representation of the instructor.
     *
     * @return a string containing the instructor's details.
     */
    public String toString() {
        return "ID: " + this.getID() + " | Name: "
                + this.getName() + " | Gender: " + this.getGender() +
                " | Birthday: " + this.getbDay() + " | Age: " + this.getAge() +
                " | Balance: " + this.getBalance() + " | Role: Instructor | Salary per Hour: "
                + this.getSalary() + " | Certified Classes: " + this.validSessionsToString();
    }

    /**
     * Converts the list of valid sessions into a comma-separated string.
     *
     * @return a string representation of the valid session types.
     */
    private String validSessionsToString() {
        String s = "";
        for (SessionType validSession : validSessions) {
            s = s + validSession.toString();
            // Check if the current session is the last one to avoid appending a comma.
            if (!validSession.equals(validSessions.getLast()))
                s = s + ", ";
        }
        return s;
    }
}
