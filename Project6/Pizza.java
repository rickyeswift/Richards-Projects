/*
* Pizza.java
* This code simulates a pizza in a pizza shop with its sauce and toppings
* That our patron will order.
* Richard Elliott Jr
* 04/15/1992
* CMSC 255-902
 */
package Projects.Project6;

public class Pizza {
    // Create private variables Size, Sauce, Crust, Cheese, MeatTopping, VeggieTopping
    private Size size;
    private Crust crust;
    private Sauce sauce;
    private MeatTopping meatTopping;
    private VeggieTopping veggieTopping;

    /** Create default constructor pizza() */
    public Pizza() {
        this.size = Size.SMALL;
        this.crust = Crust.HAND_TOSSED;
        this.sauce = Sauce.MARINARA;
        this.meatTopping = MeatTopping.none;
        this.veggieTopping = VeggieTopping.none;
    }

    /** Create parameterized constructor Pizza */
    public Pizza(Size size, Crust crust, Sauce sauce, MeatTopping meatTopping, VeggieTopping veggieTopping) {
        this.size = size;
        this.crust = crust;
        this.sauce = sauce;
        this.meatTopping = meatTopping;
        this.veggieTopping = veggieTopping;
    }

    /** getters and setters */
    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setMeatTopping(MeatTopping meatTopping) {
        this.meatTopping = meatTopping;
    }

    public MeatTopping getMeatTopping() {
        return meatTopping;
    }

    public void setVeggieTopping(VeggieTopping veggieTopping) {
        this.veggieTopping = veggieTopping;
    }

    public VeggieTopping getVeggieTopping() {
        return veggieTopping;
    }

    /** A toString that prints the characteristics of each pizza */
    public String toString() {
        return "\n" + "\t" + size + "\n" + "\t" + crust + "\n" + "\t" + sauce + "\n" + "\t" + meatTopping + "\n" + "\t" +
                veggieTopping + "\n";
    }
}
