/**
 * @author Tresor Bitangimana
 * @since Jan 16 /2026
 */


public class Payroll {

    private int NUM_EMPLOYEES = 7; //private field for the number of employees
    //private field for employee ID
    private int[] employeeId = new int[] {5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489 }; 
    private int[] hours = new int[NUM_EMPLOYEES]; //private field for hours
    private double[] payRate = new double[NUM_EMPLOYEES]; //private field for the pay rate
    private double[] wages = new double[NUM_EMPLOYEES]; //private field for the wages

    /**
     * returns the gross pay of an employee by mutiplying their hourly pay with payrate
     * @param i
     * @return gross pay
     */
    public double getGrossPay(int i){
        return hours[i] * payRate[i];
    }

    /**
     * sets the employees id at a specified index
     * @param i
     * @param id
     */
    public void setEmployeeIdAt(int i, int id){
        if(i > -1 && i < 7){
            employeeId[i] = id;
        }
        else{
            System.out.println("invalid id slot");
        }
    }

    /**
     * sets the employee hours at a specified index
     * @param i
     * @param h
     */
    public void setHoursAt(int i, int h){
        if(h >= 0){
            hours[i] = h;
        }
        else{
            System.out.println("houts can not be negative");
        }
    }

    /**
     * sets the pay rate at a specified index
     * @param i
     * @param p
     */
    public void setPayRateAt(int i, double p){
        if(p >= 6){
            payRate[i] = p;
        }
        else{
            System.out.println("Pay rate can not be less than 6.00");
        }
    }

    /**
     * sets a specified wages at a specified index
     * @param i
     * @param w
     */
    public void setWagesAt(int i, double w){
        if(i > -1 && i < 7){
            wages[i] = w;
        }
        else{
            System.out.println("invalid wages slot");
        }
    }

    /**
     * gets the employee id at a specified index
     * @param i
     * @return id
     */
    public int getEmployeeIdAt(int i){
        if(i > -1 && i < 7){
            return employeeId[i];
        }
        else{
            return 0;
        }
    }

    /**
     * gets the hours of an employee at a specified index
     * @param i
     * @return hours
     */
    public int getHoursAt(int i){
        if(i > -1 && i < 7){
            return hours[i];
        }
        else{
            return 0;
        }
    }

    /**
     * gets the ray rate of an employee at a specified index
     * @param i
     * @return payrate
     */
    public double getPayRateAt(int i){
        if(i > -1 && i < 7){
        return payRate[i];
        }
        else{
            return 0.0;
        }
    }

    /**
     * gets the wages of an employee at a specified index
     * @param i
     * @return wages
     */
    public double getWagesAt(int i){
        if(i > -1 && i < 7){
        return wages[i];
        }
        else{
            return 0.0;
        }
    }
}