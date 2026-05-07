package Assignment3.Course_Grade;

public class PassFailActivity extends GradedActivity{
    
    private double minPassingScore;

    public PassFailActivity(double mps){
        minPassingScore = mps;
    }

    @Override
    public char getGrade() {
        if(super.getScore() >= minPassingScore){
            return 'P';
        }
        else{
            return 'F';
        }
    }


    //demo
    public static void main(String[] args) {
        
        PassFailActivity activity = new PassFailActivity(60);
        activity.getGrade();

    }
}
