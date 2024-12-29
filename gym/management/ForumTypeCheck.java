package gym.management;

import gym.customers.Client;

import java.util.LinkedList;
import java.util.List;

/**
 * Utility class for checking if a client matches a specific forum type.
 */
public class ForumTypeCheck {
    /**
     * Determines if a client is eligible for a specified forum type.
     *
     * @param client    the client whose eligibility is being checked.
     * @param forumType the forum type to check against.
     * @return true if the client matches the forum type, false otherwise.
     */
    protected static boolean isType(Client client, ForumType forumType) {
        // List to store all forum types applicable to the client
        List<ForumType> currentType = new LinkedList<>();

        // All clients belong to the "All" forum type
        currentType.add(ForumType.All);

        // Clients aged 65 and older belong to the "Seniors" forum type
        if (client.getAge() >= 65)
            currentType.add(ForumType.Seniors);

        // Add the forum type corresponding to the client's gender
        if (client.getGender().toString().equals(ForumType.Male.toString()))
            currentType.add(ForumType.Male);
        else currentType.add(ForumType.Female);

        // Check if the specified forum type is in the list of applicable types
        return currentType.contains(forumType);
    }
}
