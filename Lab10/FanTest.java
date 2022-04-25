/*
* Test your class by creating another class called FanTest within the Lab10 package.
* This class will contain a main method.
* Within the main method create two objects of the class Fan.
* The first object will have the maximum speed, radius of 10, a color of yellow, and the fan will be on.
* The second fan will have medium speed, radius of 20, color of blue and this fan will be off.
* Display both objects by invoking their toString() method.
* Richard Elliott Jr
* Lab10
* CMSC 255-902
* 03/30/2022
 */
package Labs.Lab10;

public class FanTest {
    /** Main method */
    public static void main(String[] args) {
        final int SLOW = 1;
        final int MEDIUM = 2;
        final int FAST = 3;

        // Create two Fan objects
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        //Assign maximum speed, radius 10, color yellow
        // and turn it on to the first object
        fan1.setSpeed(FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.turnOn();

        // Assign medium speed, radius 5, color blue,
        // and turn it off to the second object
        fan2.setSpeed(MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.turnOff();

        // Display the objects by invoking their toString method
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
