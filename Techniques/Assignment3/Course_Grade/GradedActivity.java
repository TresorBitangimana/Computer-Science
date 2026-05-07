package Assignment3.Course_Grade;

public class GradedActivity{
    
    private double score;

    public GradedActivity(){
        this.score = 0;
    }

    public void setScore(double s){
        score = s;
    }

    public double getScore(){
        return score;
    }

    public char getGrade(){
        char grade = ' ';

        if(score >= 90 && score <= 100){
            grade = 'A';
        }
        else if(score >= 80 &&  score < 90){
            grade = 'B';
        }
        else if (score >= 70 &&  score < 80 ){
            grade = 'C';
        }
        else if(score > 0 && score < 70){
            grade = 'F';
        }
        else{
            grade = 'A';
            System.out.println("Wow thats some extra point you got there");
        }

        return grade;
    }


    //demo
    public static void main(String[] args) {
        
        GradedActivity graded = new GradedActivity();

        graded.setScore(75);
        System.out.println(graded.getScore());
        System.out.println(graded.getGrade());

    }
}
