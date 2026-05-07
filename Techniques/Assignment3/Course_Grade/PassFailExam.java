package Assignment3.Course_Grade;

public class PassFailExam extends PassFailActivity{
    
    private int numQuestions;
    private double pointsEach;
    private int numMissed;

    public PassFailExam(int questions, int missed, double minPassing){
        super(minPassing);
        numQuestions = questions;
        numMissed = missed;
        pointsEach = 100.0/numQuestions;
        double score = (questions - missed) * pointsEach;
        setScore(score);
    }

    public double getPointsEach(){
        return pointsEach;
    }

    public int getNumMissed(){
        return numMissed;
    }

    //demo
    public static void main(String[] args) {
        
        // PassFailExam exam = new PassFailExam(10, 4, 60);

    }
}
