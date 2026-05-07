package StudyCase;

public abstract class Person {
    
    protected String name;
    int age;

    public Person(){
        this.name = "Unknown";
        this.age = 0;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public  void introduce(){
        System.out.println("Name: "+name+" Age: "+age);
    }

    public abstract String getRole();

}
