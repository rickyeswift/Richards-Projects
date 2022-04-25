/*
*Lab12 Card.java
* This code represents a general type of membership card
* Richard Elliott
* CMSC 255-902
* April 13, 2022
 */
package Labs.Lab12;

public class Card {
    //Variable
    private String name;

    //Default Constructor
    public Card() {
        this.name = "";
    }

    //Parameterized Constructor
    public Card(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Card Holder: " + this.name;
    }
}
