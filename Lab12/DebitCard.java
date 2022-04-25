/*
*Lab12 DebitCard.java
* This code is a subclass to the Card Class and represents a Debit Card
* Richard Elliott
* CMSC 255-902
* April 13, 2022
 */
package Labs.Lab12;

public class DebitCard extends Card{
    //Variables
    private int cardNumber, pin;

    //Default Constructor
    public DebitCard() {
        super("Jane Doe");
        cardNumber = 00000000;
        pin = 0;
    }

    //Parameterized Constructor
     public DebitCard(String name, int cardNumber, int pin) {
        super(name);
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    @Override
    public String toString() {
        return super.toString() + " Card Number: " + this.cardNumber;
    }
}
