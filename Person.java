/**
 * The Person class represents an individual with a first name and a last name.
 * It provides methods to access and manipulate the attributes of a person.
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     * Constructs a new Person object with the specified first name and last name.
     *
     * @param firstName The first name of the person.
     * @param lastName  The last name of the person.
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Gets the first name of the person.
     *
     * @return The first name of the person.
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Gets the last name of the person.
     *
     * @return The last name of the person.
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Returns a string representation of the person.
     * The string representation consists of the person's first name followed by a space and then the last name.
     *
     * @return A string representation of the person.
     */
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
