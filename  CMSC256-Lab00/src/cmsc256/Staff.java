/*
 * CMSC256 Summer2022
 * Staff.java
 * Richard Elliott
 * 06/02/2022
 */
package cmsc256;

import java.time.LocalDate;

/**
 *  A class that represents a Staff's information and provides
 *  a formatted string representation of the instance variables.
 *
 * @author Richard Elliott
 * @version 2.0
 */
public class Staff extends Employee {
    private String phoneNumber;
    private String email;
    private Name name;
    private Address homeAddress;
    private String office;
    private int salary;
    private LocalDate hireDate;
    private String title;

    /**
     * Default values for phoneNumber, email, and title is "None given"
     * Default value for office is "Unassigned"
     * Default value for salary is 0
     * Default value for hireDate is null;
     */
    public Staff() {
        this.phoneNumber = "None given";
        this.email = "None given";
        this.office = "Unassigned";
        this.salary = 0;
        this.hireDate = null;
        this.title = "None given";
    }

    /**
     *
     * @param first     the first name
     * @param middle    the middle name
     * @param last      the last name
     * @param homeAddress the address
     * @param phoneNumber the phone number
     * @param email     the email
     * @param office    the office
     * @param salary    the salary
     * @param month     the month
     * @param day       the day
     * @param year      the year
     * @param newTitle  the title
     */
    public Staff (String first, String middle, String last, Address homeAddress, String phoneNumber,
                  String email, String office, int salary, int month, int day, int year, String newTitle) {
        super(first, middle, last, homeAddress, phoneNumber, email, office, salary, month, day, year);
        this.title = newTitle;
    }

    /**
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return the components of Staff as a formatted String
     */
    public String toString() {
        String result5 = super.toString() + "Title:\t" + this.title;
        return result5 + "\n";
    }
}
