package Labs.Lab12;

public class IDCard extends Card{
    //Declaring variables
    private int idNumber;

    //Default Constructor
    public IDCard() {
        super("Jane Smith");
        this.idNumber = 0;
    }

    //Parameterized Constructor
    public IDCard(String name, int idNumber) {
        super(name);
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " ID Number: " + this.idNumber;
    }
}
