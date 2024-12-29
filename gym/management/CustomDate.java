package gym.management;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for formatting and converting date strings between different patterns.
 */
public class CustomDate {
    /**
     * Converts a date string from the format "dd-MM-yyyy HH:mm" to the format "yyyy-MM-dd'T'HH:mm".
     *
     * @param inputString the input date string in the format "dd-MM-yyyy HH:mm".
     * @return the formatted date string in the ISO-like format "yyyy-MM-dd'T'HH:mm".
     */
    protected static String customDate(String inputString) {
        // Define the input date format
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        // Define the desired output date format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        // Parse the input string into a LocalDateTime object
        LocalDateTime dateTime = LocalDateTime.parse(inputString, inputFormatter);

        // Format the LocalDateTime object into the desired output format
        return dateTime.format(outputFormatter);
    }
}
