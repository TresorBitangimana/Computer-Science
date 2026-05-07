package StudyCase;

public class TeachingAssistant extends Student implements Worker{
    
    TeachingAssistant(String name, int age, String studentId){
        super(name, age, studentId);
    }

    public void work(){
        System.out.println("I am working");
    }



}