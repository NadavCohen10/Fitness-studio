package gym.customers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for validating if a given date is in the future.
 */
public class futureDate {
    /**
     * Checks if a given date string represents a date that is in the future compared to the current date.
     *
     * @param inputDate the date string in the format "dd-MM-yyyy HH:mm".
     * @return true if the date is in the future, false otherwise or if the input is invalid.
     */
    public static boolean isDateInFuture(String inputDate) {

        // Define the expected date format
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        dateFormat.setLenient(false); // Enforce strict date validation

        try {
            // Parse the input date string into a Date object
            Date parsedDate = dateFormat.parse(inputDate);
            // Get the current date and time
            Date currentDate = new Date();
            // Check if the parsed date is before the current date
            return parsedDate.before(currentDate);

        } catch (ParseException e) {
            // Return false if the date string is invalid or cannot be parsed
            return false;
        }
    }
}
