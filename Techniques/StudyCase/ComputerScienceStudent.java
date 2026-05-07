package StudyCase;

public class ComputerScienceStudent extends Person{
    
    private String favoriteLanguage;

    public ComputerScienceStudent(String name, int age,String favoriteLanguage){
        super(name, age);
        this.favoriteLanguage = favoriteLanguage;

    }

    @Override
    public void introduce(){
        super.introduce();
        System.out.println("Hello I am a Computer Science student, my favorute language is "+favoriteLanguage);
    }

    @Override
    public String getRole(){
        return "Computer Science student";
    }

    public void code(){
        System.out.println("The student is coding in"+favoriteLanguage);
    }
}
