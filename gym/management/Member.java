package gym.management;

/**
 * Interface representing a member in the gym system.
 * Any class implementing this interface must define the behavior for receiving updates, such as newsletters.
 */
public interface Member {
    /**
     * Updates the member with a provided newsletter.
     *
     * @param newsletter the newsletter content to be sent to the member.
     */
    void update(String newsletter);
}
