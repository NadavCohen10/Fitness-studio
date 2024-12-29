package gym.customers;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for calculating the age based on a given date of birth.
 */
public class Age {

    /**
     * Calculates the age of a person based on their birthdate.
     *
     * @param date the birthdate in the format "dd-MM-yyyy".
     * @return the calculated age in years.
     */
    public static int getAge(String date) {
        // Define the date format to match the input string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // Parse the input date string into a LocalDate object
        LocalDate birthDate = LocalDate.parse(date, formatter);
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        // Calculate the age as the period between the birthdate and the current date
        Period age = Period.between(birthDate, currentDate);
        // Return the number of years in the calculated age
        return age.getYears();
    }
}
