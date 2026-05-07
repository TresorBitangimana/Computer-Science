package Assignment3.Course_Grade;

public class CourseGrades implements Analyzable{
    
    private GradedActivity[] grades;
    private int NUM_GRADES = 4;
    
    
    public CourseGrades(){
        grades = new GradedActivity[NUM_GRADES];
    }

    public void setLab(GradedActivity aLab){
        grades[0] = aLab;
    }

    public void setPassFailExam(PassFailExam aPassFailExam){
        grades[1] = aPassFailExam;
    }

    public void setEssay(Essay anEssay){
        grades[2] = anEssay;
    }

    public void setFinalExam(FinalExam aFinalExam){
        grades[3] = aFinalExam;
    }

    @Override
    public String toString() {
        return "Lab: Score = "+ grades[0].getScore()+ " Grade = "+grades[0].getGrade()+
                "\nPassFailExam: Score = "+ grades[1].getScore()+ " Grade = "+grades[1].getGrade()+
                "\nEssay: Score = "+ grades[2].getScore()+ " Grade = "+grades[2].getGrade()+
                "\nFinalExam: Score = "+ grades[3].getScore()+ " Grade = "+grades[3].getGrade();

    }

    @Override
    public double getAverage() {
        double average= 0;

        for(int i = 0; i < grades.length; i++){
            average += grades[i].getScore();
        }

        average = average / grades.length;

        return average;
    }

    @Override
    public GradedActivity getHighest() {
        double highestScore = grades[0].getScore();
        int index = 0;

        for(int i = 0; i < grades.length; i++){
            if(grades[i].getScore() > highestScore){
                index = i;
                highestScore = grades[i].getScore();
            }
        }

        return grades[index];
    }

    @Override
    public GradedActivity getLowest() {
        double lowestScore = grades[0].getScore();
        int index = 0;

        for(int i = 0; i < grades.length; i++){
            if(grades[i].getScore() < lowestScore){
                index = i;
                lowestScore = grades[i].getScore();
            }
        }

        return grades[index];
    }

    //demo
    public static void main(String[] args){

        CourseGrades course = new CourseGrades();

        LabActivity lab = new LabActivity("TA Martin", 85);
        PassFailExam passFailExam = new PassFailExam(10, 2, 60);
        Essay essay = new Essay(25, 18, 17, 28); 
        FinalExam finalExam = new FinalExam(50, 5);

        course.setLab(lab);
        course.setPassFailExam(passFailExam);
        course.setEssay(essay);
        course.setFinalExam(finalExam);

        // Display all grades
        System.out.println("Course Grades");
        System.out.println(course);

        // Display analytics
        System.out.println("Average Score: " + course.getAverage());
        System.out.println("Highest Score: " +
                course.getHighest().getScore() +
                " (" + course.getHighest().getGrade() + ")");
        System.out.println("Lowest Score: " +
                course.getLowest().getScore() +
                " (" + course.getLowest().getGrade() + ")");

    }
}
