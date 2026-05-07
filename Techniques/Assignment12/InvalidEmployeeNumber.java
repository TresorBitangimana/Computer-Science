package Assignment12;

public class InvalidEmployeeNumber extends RuntimeException {

    public InvalidEmployeeNumber(String str) {
        super(str);
    }

    public InvalidEmployeeNumber() {
        super("The Employee number is not valid");
    }

}
