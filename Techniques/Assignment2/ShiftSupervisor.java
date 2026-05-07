/**
 * @author Tresor Bitangimana
 * @since Jan 26/ 2026
 * 
 *  ShiftSpervisor class, create a shift supervisor object that extends the employee class
 *  it stoles the employees salary and bonus.
 */


package Assignment2;

public class ShiftSupervisor extends Employee{
    
    private double salary;
    private double bonus;

    public ShiftSupervisor(String n, String num, String date, double sal, double b){
        super(n, num, date);

        salary = sal;
        bonus = b;
    }

    public ShiftSupervisor(){
        super();
        salary = 0.0;
        bonus = 0.0;
    }

    public void setSalary(double s){
        salary = s;
    }

    public void setBonus(double b){
        bonus = b;
    }

    public double getSalary(){
        return salary;
    }

    public double getBonus(){
        return bonus;
    }

    @Override
    public String toString(){
        return super.toString()+"Salary: "+salary+" \n Bonus: "+bonus; 
    }

    public static void main(String[] args) {
        
        //test
        ShiftSupervisor worker = new ShiftSupervisor("Sam", "9872-D", "Jan 27/ 2025", 50000, 10000);

        System.out.println(worker.getName());
        System.out.println(worker.getEmployeeNumber());
        System.out.println(worker.getHireDate());
        System.out.println(worker.getSalary());;
        System.out.println(worker.getBonus());

        worker.setName("Bob");
        System.out.println(worker.getName());

    }

}
