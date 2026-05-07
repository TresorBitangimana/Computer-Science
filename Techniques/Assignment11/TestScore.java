
/**
 * @Author Tresor Bitangimana
 * @Since April 13/2026
 * Test Score class
 */
package Assignment11;

public class TestScore {

    private double[] scores;

    /**
     * Constructor
     * 
     * @param s
     */
    public TestScore(double[] s) {
        scores = s;
    }

    /**
     * getAverage class,
     * takes the scores array and calsulates the average of all values
     * 
     * @return the average of the scores array
     * @throws IllegalArgumentException if a negative score or a score greater
     *                                  than 100 is found in the array
     */
    public double getAverage() throws IllegalArgumentException {
        double score = 0.0;
        for (int i = 0; i < scores.length; i++) {
            // checks if a score is negative or greater than 100.
            if (scores[i] < 0) {
                throw new InvalidTestScore("invalid element " + scores[i] + " was found at index " + i);
            } else if (scores[i] > 100) {
                throw new InvalidTestScore("invalid element " + scores[i] + " was found at index " + i);
            }
            // sums up all the scores
            score += scores[i];
        }
        return score / scores.length;
    }
}
