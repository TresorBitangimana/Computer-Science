package Assignment12;

public class InvalidPayRate extends RuntimeException {

    public InvalidPayRate(String str) {
        super(str);
    }

    public InvalidPayRate() {
        super("The pay rate can not be negative");
    }

}
