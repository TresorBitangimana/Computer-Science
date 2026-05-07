package Assignment8;

public class Employee {
    
    private String idNumber; //id number field
    private String name;     //name field

    /**
     * constructor method
     * @param id
     * @param n
     */
    public Employee(String id, String n){
        idNumber = id;
        name = n;
    }

    /**
     * getter method for the id number
     * @return id number
     */
    public String getIdNumber(){
        return idNumber;
    }

    /**
     * getter method for the name
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * toString method
     * @return a string with the employee information
     */
    @Override
    public String toString() {
        return "Name: "+name +"\nId Number: "+idNumber;
    }


}
