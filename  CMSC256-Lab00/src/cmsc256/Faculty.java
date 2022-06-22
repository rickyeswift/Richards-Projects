/*
 * CMSC256 Summer2022
 * Faculty.java
 * Richard Elliott
 * 06/02/2022
 */
package cmsc256;

import java.time.LocalDate;

/**
 *  A class that represents a Faculty's information and provides
 *  a formatted string representation of the instance variables.
 *
 * @author Richard Elliott
 * @version 2.0
 */
public class Faculty extends Employee{
    private String phoneNumber;
    private String email;
    private Name name;
    private Address homeAddress;
    private String office;
    private int salary;
    private LocalDate hireDate;
    private String rank;

    /**
     * Sets default values for the object.
     *  Default value for phoneNumber and email is "None given"
     *  Default value for office is "Unassigned"
     *  Default value for salary is 0
     *  Default value for hireDate is null
     *  Default value for rank is "Instructor";
     */
    public Faculty() {
        this.phoneNumber = "None given";
        this.email = "None given";
        this.office = "Unassigned";
        this.salary = 0;
        this.hireDate = null;
        this.rank = "Instructor";
    }

    /**
     *
     * @param first     the first name
     * @param middle    the middle name
     * @param last      the last name
     * @param homeAddress   the address
     * @param phoneNumber   the phone number
     * @param email     the email
     * @param office    the office
     * @param salary    the salary
     * @param month     the month
     * @param day       the day
     * @param year      the year
     * @param newRank   the rank
     */
    public Faculty (String first, String middle, String last, Address homeAddress, String phoneNumber,
                    String email, String office, int salary, int month, int day, int year, String newRank) {
        super(first, middle, last, homeAddress, phoneNumber, email, office, salary, month, day, year);
        isValidRank(newRank);
        this.rank = newRank;
    }

    /**
     *
     * @return the rank
     */
    public String getRank() {
        return rank;
    }

    /**
     *
     * @param rank the rank to set
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     *
     * @param rank1
     * @return true if the value of the String is equal to the Strings in the IF statement
     * @throws IllegalArgumentException
     */
    public boolean isValidRank(String rank1) throws IllegalArgumentException {
        if (rank1.equals("Adjunct") || rank1.equals("Instructor") || rank1.equals("Assistant Professor")
                || rank1.equals("Associate Professor") || rank1.equals("Professor")) {
            return true;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     *
     * @return the components of the Faculty as a formatted String
     */
    public String toString() {
        String result4 = super.toString() + "Rank;\t" + this.rank;
        return result4 + "\n";
    }
}
