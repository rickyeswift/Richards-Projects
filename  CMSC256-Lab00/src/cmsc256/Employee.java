/*
* CMSC256 Summer2022
* Employee.java
* Richard Elliott
* 06/02/2022
 */
package cmsc256;

import java.time.LocalDate;
/**
 *  A class that represents an Employee's information and provides
 *  a formatted string representation of the instance variables.
 *
 * @author Richard Elliott
 * @version 2.0
 */
public class Employee extends Person {
    private String office;
    private int salary;
    private LocalDate hireDate;
    private String phoneNumber;
    private String email;

    /**
     * Sets default values for the object.
     *  Default values for phoneNumber and email are "Not provided".
     *  Default value for office is "Unassigned"
     *  Default value for salary is 0
     *  Default value for hireDate is null;
     */
    public Employee() {
        this.phoneNumber = "Not provided";
        this.email = "Not provided";
        this.office = "Unassigned";
        this.salary = 0;
        this.hireDate = null;
    }

    /**
     * Sets up this Employee object with the specified data.
     *
     * @param first		the first name
     * @param middle	the middle name
     * @param last		the last name
     * @param homeAddress   the address
     * @param phoneNumber the phone number
     * @param email     the email
     * @param office    the office
     * @param salary    the salary
     * @param month     the month
     * @param day       the day
     * @param year      the year
     */
    public Employee (String first, String middle, String last, Address homeAddress, String phoneNumber,
                     String email, String office, int salary, int month, int day, int year) {
        super(first, middle, last, homeAddress, phoneNumber, email);
        this.office = office;
        // Check if salary is negative, if so throw IllegalArgumentException()
        if (salary < 0) {
            throw new IllegalArgumentException();
        }
        this.salary = salary;
        this.hireDate = LocalDate.of(year, month, day);

    }

    /**
     *
     * @return the office
     */
    public String getOffice() {
        return office;
    }

    /**
     *
     * @param office the office to set
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     *
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     *
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     *
     * @return the hireDate
     */
    public LocalDate getHireDate() {
        return hireDate;
    }

    /**
     *
     * @param hireDate the hireDate to set
     */
    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    /**
     *
     * @return the components of the Employee as a formatted String.
     */
    public String toString() {
        // String format if there is no hireDate
        if (this.hireDate == null) {
            return super.toString() + "Office: \t" + this.office + "\nSalary:\t$" + this.salary + "\nDate Hired:\t" + null + "\n";
        }
        else {
            // String format when there is a vale for hireDate
            return super.toString() + "Office:\t" + this.office + "\nSalary:\t$" + this.salary + "\nDate Hired:\t"
                    + this.hireDate.getMonthValue() + "/" + this.hireDate.getDayOfMonth() + "/" + this.hireDate.getYear() + "\n";
        }
    }
}
