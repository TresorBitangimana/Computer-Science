package StudyCase;

public class Student extends Person{

    protected String studentId;
    
    Student(String name, int age, String studentId){
        super(name, age);
        this.studentId = studentId;
    }

    @Override
    public void introduce(){
        super.introduce();
        System.out.println("Hello I am a student");
    }

    @Override
    public String getRole(){
        return "Student";
    }

}
