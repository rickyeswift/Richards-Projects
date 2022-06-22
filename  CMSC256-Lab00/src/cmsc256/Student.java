/*
 * CMSC256 Summer2022
 * Student.java
 * Richard Elliott
 * 06/02/2022
 */
package cmsc256;
/**
 *  A class that represents a Student's information and provides
 *  a formatted string representation of the instance variables.
 *
 * @author Richard Elliott
 * @version 2.0
 */
public class Student extends Person {
    private String level;
    private Name name;
    private Address homeAddress;
    private String phoneNumber;
    private String email;

    /**
     * Sets default values for the object.
     *  Default values for name is the class Name
     *  Default value for address is the class Address
     *  Default value for phoneNumber and email is "None given"
     *  Default value for level is "Freshman";
     */
    public Student() {
        this.name = new Name();
        this.homeAddress = new Address();
        this.phoneNumber = "None given";
        this.email = "None given";
        this.level = "Freshman";
    }

    /**
     * Sets up this Employee object with the specified data.
     *
     * @param first		the first name
     * @param middle	the middle name
     * @param last		the last name
     * @param homeAddress the address
     * @param phoneNumber the phone number
     * @param email      the email
     * @param initialLevel the level
     */
    public Student(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String initialLevel) {
        super(first, middle, last, homeAddress, phoneNumber, email);
        setLevel(initialLevel);
    }

    /**
     *
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     *
     * @param newLevel the level to set
     * @throws IllegalArgumentException
     */
    public void setLevel(String newLevel) throws IllegalArgumentException {
        if("Freshman".equalsIgnoreCase(newLevel)
                || "Sophomore".equalsIgnoreCase(newLevel)
                || "Junior".equalsIgnoreCase(newLevel)
                || "Senior".equalsIgnoreCase(newLevel)
                || "Graduate".equalsIgnoreCase(newLevel))
            level = newLevel;
        else
            throw new IllegalArgumentException(newLevel + " is an invalid level");
    }

    /**
     *
     * @return the components of the Student as a formatted String
     */
    @Override
    public String toString() {
        super.toString();
        return super.toString() + "College level: " + this.level + "\n";
    }
}
