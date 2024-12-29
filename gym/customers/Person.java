package gym.customers;

/**
 * Represents a Person with attributes such as name, balance, gender, birthdate, and a unique ID.
 */
public class Person {
    // Attributes of the Person class
    private String name;
    protected int[] balance = new int[1]; // Balance stored as a single-element array for shared updates
    private Gender gender;
    final private String BIRTH_DAY;
    final private int ID;
    private static int countPerson; // Counter for generating unique IDs


    /**
     * Constructor to initialize a new Person.
     *
     * @param name    the name of the person.
     * @param balance the initial balance of the person.
     * @param gender  the gender of the person.
     * @param bDay    the birthdate of the person.
     */
    public Person(String name, int balance, Gender gender, String bDay) {
        this.name = name;
        this.balance[0] = balance;
        this.gender = gender;
        this.BIRTH_DAY = bDay;
        ID = 1110 + ++countPerson; // Generates a unique ID starting from 1111
    }

    /**
     * Copy constructor to create a new Person based on an existing one.
     *
     * @param person the Person object to copy from.
     */
    protected Person(Person person) {
        this.name = person.getName();
        this.balance = person.balance;
        this.gender = person.getGender();
        this.BIRTH_DAY = person.getbDay();
        this.ID = person.getID();
    }

    /**
     * Calculates and retrieves the person's age based on their birthdate.
     *
     * @return the age of the person.
     */
    public int getAge() {
        return Age.getAge(this.BIRTH_DAY); // Delegates age calculation to the Age class
    }

    /**
     * Retrieves the person's gender.
     *
     * @return the gender of the person.
     */
    public Gender getGender() {
        return this.gender;
    }

    /**
     * Retrieves the person's name.
     *
     * @return the name of the person.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the person's current balance.
     *
     * @return the current balance.
     */
    public int getBalance() {
        return this.balance[0];
    }

    /**
     * Reduces the person's balance by a specified amount.
     *
     * @param paying the amount to deduct from the balance.
     */
    public void reduceBalance(int paying) {
        this.balance[0] -= paying;
    }

    /**
     * Increases the person's balance by a specified amount.
     *
     * @param paying the amount to add to the balance.
     */
    public void increaseBalance(int paying) {
        this.balance[0] += paying;
    }

    /**
     * Retrieves the person's birthdate.
     *
     * @return the birthdate as a String.
     */
    public String getbDay() {
        return this.BIRTH_DAY;
    }

    /**
     * Retrieves the person's unique ID.
     *
     * @return the unique ID.
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Compares this person with another object for equality based on their unique IDs.
     *
     * @param obj the object to compare with.
     * @return true if the IDs are equal; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return this.getID() == ((Person) obj).getID();
    }
}



