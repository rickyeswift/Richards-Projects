package Labs.Lab12;


public class DriversLicense extends IDCard {
    private int expirationYear;
    private Month expirationMonth;

    //Default Constructor
    public DriversLicense() {
        super();
        this.expirationYear = 1969;
        this.expirationMonth = Month.JANUARY;
    }

    //Parameterized Constructor
    public DriversLicense(String name, int idNumber, int expirationYear, Month expirationMonth) {
        super(name, idNumber);
        this.expirationYear = expirationYear;
        this.expirationMonth = expirationMonth;
    }

    @Override
    public String toString() {
        return super.toString() + (" Expiration Month & Year: " + this.expirationMonth + " " + this.expirationYear);
    }
}
