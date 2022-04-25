/*
*         Fan          *
* ---------------------*
* +SLOW: int           *
* ----------           *
* +MEDIUM: int         *
* ------------         *
* +FAST: int           *
* ----------           *
* -speed: int          *
* -on: boolean         *
* -radius: double      *
* +color: String       *
* +Fan()               *
* +setSpeed(int)       *
* +turnOn()            *
* +turnOff()           *
* +setRadius(double):  *
* +setColor(String):   *
* +getSpeed(): String  *
* +isOn(): boolean     *
* +getRadius(): double *
* +getColor(): String  *
* +toString(): String  *
* Richard Elliott Jr
* LAB10
* CMSC 255-902
 *03/30/2022
 */
package Labs.Lab10;

public class Fan {
    public final static int SLOW = 1;
    public final static int MEDIUM = 2;
    public final static int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    /** Default Constructor */
    public Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    /** Setters and Getters */
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    /** Sets fan on */
    public void turnOn() {
        on = true;
    }

    /** Sets fan off */
    public void turnOff() {
        on = false;
    }

    /** Returns a string description for the fan */
    public String toString() {
        if (on == true) {
            return "fan is " + getSpeed() + ", " + color +
                    ", and size " + radius;
        }
        else if (on == false) {
        }
        return "fan is off";
    }
}
