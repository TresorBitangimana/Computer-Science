/**
 * @author Tresor Bitangimana
 * @since Jan 26/ 2026
 * 
 *  Employee class, create an employee and stoles the employees name
 *  employee number and hire date.
 */

package Assignment2;

public class Employee {
    
    //name employee name field
    private String name;
    //imployee number field
    private String employeeNumber;
    //employee hire date field
    private String hireDate;

    /**
     * constructor method for the class.
     * @param n
     * @param num
     * @param date
     */
    public Employee(String n, String num, String date){
        name = n;
        employeeNumber = num;
        hireDate = date;
    }

    public Employee(){
        name = "";
        employeeNumber = "";
        hireDate = "";
    }

    /**
     * setter method for the name
     * @param n
     */
    public void setName(String n){
        name = n;
    }

    /**
     * setter memthod for the employee number
     * @param e
     */
    public void setEmployeeNumber(String e){
        employeeNumber = e;
    }

    /**
     * setter method for the hire date
     * @param h
     */
    public void setHireDate(String h){
        hireDate = h;
    }

    /**
     * getter method for the name
     * @return name, of the employee
     */
    public String getName(){
        return name;
    }

    /**
     * getter method for the employee number
     * @return employeeNumber
     */
    public String getEmployeeNumber(){
        return employeeNumber;
    }

    /**
     * getter method for the hire date
     * @return hireDate, the date the employee was hired
     */
    public String getHireDate(){
        return hireDate;
    }

    /**
     * checks if an emoployee number is valid
     * @param e
     * @return true, if the empployee number is valid
     *         false, if the employee number is not valid.
     */
    private boolean isValidEmpNum(String e){
        if(employeeNumber.equals(e)){
            return true;
        }
        return false;
    }

    /**
     * toString method, returns a string with the employee name, employeee number and hire date.
     */
    @Override
    public String toString(){
        return "Name: "+name+" \nEmployee Number: "+employeeNumber+" \nHire date: "+hireDate;
    }

    public static void main(String[] args) {
        
        Employee employee = new Employee("John", "8732-D", "Oct 15/ 2025");

        System.out.println(employee.getName());
        System.out.println(employee.getEmployeeNumber());
        System.out.println(employee.getHireDate());

        System.out.println(employee.isValidEmpNum("9245-C"));
    }
}
