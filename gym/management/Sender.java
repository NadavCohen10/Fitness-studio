package gym.management;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class that provides functionality for managing members
 * and notifying them about updates or events.
 */
public abstract class Sender {

    // List of registered members who will receive notifications.
    private final List<Member> members = new ArrayList<>();

    /**
     * Registers a new member to receive notifications.
     *
     * @param member the member to be added to the notification list.
     */
    protected void register(Member member) {
        members.add(member);
    }

    protected void notifyMembers(String newsletter) {
        for (Member member : members) {
            member.update(newsletter);
        }
    }

}
