package gym.management;

/**
 * Handles the publishing of newsletters to members.
 * Extends the {@link Sender} class to notify members of new content.
 */
public class NewsletterPublisher extends Sender {

    /**
     * Sends a newsletter to all members by utilizing the notifyMembers method from the parent class.
     *
     * @param content the content of the newsletter to be sent.
     */
    protected void sendNewsletter(String content) {
        notifyMembers(content);
    }
}
