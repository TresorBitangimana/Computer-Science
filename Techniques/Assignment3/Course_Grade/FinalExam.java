package Assignment3.Course_Grade;

public class FinalExam extends GradedActivity{
    
    private int numQuestion;
    private int numMissed;

    public FinalExam(int questions, int missed){
        numQuestion = questions;
        numMissed = missed;
        double score = (questions - missed) * (100.0 / questions);
        setScore(score);
    }

    public int getNumQuestions(){
        return numQuestion;
    }

    public int getNumMissed(){
        return numMissed;
    }

    public double getPointsEach(){
        return (100.0 / numQuestion);
    }

    //demo
    public static void main(String[] args) {
        
        FinalExam exam = new FinalExam(10, 6);

        System.out.println(exam.getNumMissed());
        System.out.println(exam.getNumQuestions());

        System.out.println(exam.getPointsEach());

    }
}
