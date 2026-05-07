package Assignment12;

public class InvalidShift extends RuntimeException {

    public InvalidShift(String str) {
        super(str);
    }

    public InvalidShift() {
        super("The shift is invalid");
    }

}
