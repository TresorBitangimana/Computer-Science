package Assignment11;

public class TestScoreDemo {
    public static void main(String[] args) {

        double[] badScoresList = { 10, 35, 100, 0, 85, 15, 99, 67, 55, 101 };
        double[] goodScoresList = { 10, 35, 100, 0, 85, 15, 99, 67, 55 };

        TestScore scores1 = new TestScore(badScoresList);
        TestScore scores2 = new TestScore(goodScoresList);

        try {
            System.out.println(scores1.getAverage());
        } catch (InvalidTestScore e) {
            System.out.println(e);
        }

        try {
            System.out.println(scores2.getAverage());
        } catch (InvalidTestScore e) {
            System.out.println(e);
        }

    }
}
