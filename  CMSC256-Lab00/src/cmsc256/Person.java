/*
 * CMSC256 Summer2022
 * Person.java
 * Richard Elliott
 * 06/02/2022
 */
package cmsc256;

/**
 *  A class that represents a Person's information and provides
 *  a formatted string representation of the instance variables.
 *
 * @author Richard Elliott
 * @version 2.0
 */
public class Person {
    private final int id;
    private Name name;
    private Address homeAddress;
    private String phoneNumber;
    private String email;
    private static int recordNumber;

    /**
     * Sets default values for the object.
     *  Default values for name is the class Name
     *  Default value for address is the class Address
     *  Default value for phoneNumber and email is "None given"
     *  Default value for id pre-incremented recordNumber;
     */
    public Person() {
        name = new Name();
        homeAddress = new Address();
        phoneNumber = "None given";
        email = "None given";
        id = ++recordNumber;
    }

    /**
     *
     * @param first     the first name
     * @param middle    the middle name
     * @param last      the last name
     * @param homeAddress   the address
     * @param phoneNumber   the phone number
     * @param email     the email
     */
    public Person(String first, String middle, String last, Address homeAddress, String phoneNumber, String email) {
        this.name = new Name(first, middle, last);
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        id = ++recordNumber;
    }

    /**
     *
     * @return the homeAddress
     */
    public Address getHomeAddress() {
        return homeAddress;
    }

    /**
     *
     * @param homeAddress the homeAdress to set
     */
    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     *
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return the name
     */
    public Name getName() {
        return name;
    }

    /**
     *
     * @param name the name to set
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     *
     * @return the components of the Person as a formatted String
     */
    @Override
    public String toString() {
        StringBuffer result = new StringBuffer(name.toString() + "\n");
        result.append("Home Address: " + homeAddress + "\n");
        result.append("Phone Number: " + phoneNumber + "\n");
        result.append("Email: " + email + "\n");
        result.append("ID: " + id + "\n");
        return result.toString();
    }
}
