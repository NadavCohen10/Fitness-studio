package gym.customers;

import gym.management.Member;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a Client in the gym system, extending the Person class and implementing the Member interface.
 * A Client receives notifications and maintains their personal information and balance.
 */
public class Client extends Person implements Member {
    // List to store notifications sent to the client
    protected List<String> notifications = new LinkedList<>();

    /**
     * Private constructor to create a Client from an existing Person.
     *
     * @param person the Person object to base the Client on.
     */
    private Client(Person person)
    {
        super(person);
        this.balance = person.balance; // Balance is shared with the original Person

    }
    /**
     * Static factory method to create a new Client from a Person.
     *
     * @param person the Person object to convert to a Client.
     * @return a new Client instance.
     */
    public static Client newClient(Person person)
    {
        return new Client(person);
    }

    /**
     * Updates the Client with a new notification (newsletter).
     *
     * @param newsletter the message to add to the Client's notifications list.
     */
    @Override
    public void update(String newsletter) {
        notifications.add(newsletter);
    }

    /**
     * Retrieves all notifications received by the Client as a formatted StringBuilder.
     *
     * @return a StringBuilder containing the notifications in a readable format.
     */
    public StringBuilder getNotifications() {
        StringBuilder a = new StringBuilder("[");
        for (String s: notifications) {
            a.append(s);
            if(!s.equals(notifications.get(notifications.size() - 1))) {
                a.append(", ");
            }
        }
        a.append("]");
        return a;
    }

    /**
     * Provides a string representation of the Client's details.
     *
     * @return a formatted string containing the Client's attributes.
     */
    public String toString()
    {
        return "ID: " + this.getID() + " | Name: "
                + this.getName() + " | Gender: " + this.getGender() +
                " | Birthday: " + this.getbDay() + " | Age: " + this.getAge() +
                " | Balance: " + this.getBalance();
    }
}

