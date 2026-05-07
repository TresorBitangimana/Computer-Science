package Assignment11;

public class InvalidTestScore extends RuntimeException {

    public InvalidTestScore() {
        super("Invalid Test Score");
    }

    public InvalidTestScore(String s) {
        super(s);
    }

}
