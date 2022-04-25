/*
*Patron.java
* This code gathers the information of the patron at the pizza shop and their order than outputs
* the order and information of the patron to the user
* Richard Elliott Jr
* 04/16/2022
* CMSC 255-902
 */
package Projects.Project6;

import javax.swing.*;
import java.util.ArrayList;

public class Patron extends Pizza {
    // Create private Strings lastName, firstName, phone, email and streetAddress
    private String lastName;
    private String firstName;
    private String phone;
    private String email;

    // Create private ArrayList<Pizza> pizzas
    private ArrayList<Pizza> pizzas;

    /**
     * Create default constructor Patron()
     */
    public Patron() {
        this.lastName = "";
        this.firstName = "";
        this.phone = "";
        this.email = "";
        this.pizzas = new ArrayList<>();
    }

    /**
     * Create parameterized constructor Patron
     */
    public Patron(String firstName, String lastName, String phone, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.pizzas = new ArrayList<>();
    }

    /**
     * getters and setters
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Create method addPizza to add a pizza to the patrons order
     */
    public void addPizza(Pizza p) {
        pizzas.add(p);
    }

    public int getNumPizzas() {
        return pizzas.size();
    }


    // This method returns the patrons order from the Pizza ArrayList
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * Create a toString that outputs the patrons information
     */
    @Override
    public String toString() {
        return firstName + "\n" + lastName + "\n" + phone + "\n" + email + "\n" + "Pizzas:" + "\n" + pizzas.toString().replace("[","").replace("]","").replace(",","");
    }
}