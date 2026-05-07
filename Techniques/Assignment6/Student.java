package Assignment6;

public class Student<ID> extends Person<ID> {
    
    protected double gpa;

    public Student(ID id, String name, double gpa){
        super(id, name);
        this.gpa = gpa;
    }

    public double getGpa(){
        return gpa;
    }

    @Override
    public void displayInfo(){
        System.out.println("Name: "+name+" Role: Student \nID: "+id+" \nGPA: "+gpa); 
    }

}
 