package Assignment3.Course_Grade;

public class LabActivity extends GradedActivity{
    
    private String observer;

    public LabActivity(String ob, double score){
        observer = ob;
        setScore(score);
    }


    //demo
    public static void main(String[] args){

        LabActivity lab = new LabActivity("TA Martin", 60);
        System.out.println(lab.observer);

    }

}
