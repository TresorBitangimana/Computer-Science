/**
 * @author Tresor Bitangimana
 * @since Jan 26/ 2026
 * 
 *  Production worker, creates a production worker object that extends the employee class
 *  this class stoles the employees shift and pay rate.
 */


package Assignment2;

public class ProductionWorker extends Employee{

    //field for the employee shift
    private int shift;
    //field for the employee pay rate
    private double payRate;
    public final int DAY_SHIFT = 1;
    public final int NIGHT_SHIFT = 2;
    
    /**
     * constructor method
     * @param n
     * @param num
     * @param date
     * @param sh
     * @param rate
     */
    public ProductionWorker(String n, String num, String date, int sh, double rate){
        super(n, num, date);
        shift = sh;
        payRate = rate;
    }

    public ProductionWorker(){
        super();
        shift = 0;
        payRate = 0;
    }

    /**
     * setter method for the shift, is s == 1 then shift will be set to day shift
     * else if s == 2 shift will be set to nigh shift
     * @param s
     */
    public void setShift(int s){
        if(s == DAY_SHIFT){
            shift = DAY_SHIFT;
        }
        if(s == NIGHT_SHIFT){
            shift = NIGHT_SHIFT;
        }
    }

    /**
     * setter method for the pay rate
     * @param p
     */
    public void setPayRate(double p){
        payRate = p;
    }

    /**
     * getter method for the shift
     * @return shift
     */
    public int getShift(){
        return shift;
    }

    /**
     * getter method for the pay rate
     * @return Payrate
     */
    public double getPayRate(){
        return payRate;
    }

    /**
     * toStrong method, that returns a string with the shift and pay rate
     */
    @Override
    public String toString(){
        if(shift == 1)
            return super.toString()+"Shift: Day shift \n Pay rate: "+payRate;
        else
            return super.toString()+"Shift: Night shift \n Pay rate: "+payRate;


    }


    public static void main(String[] args) {
        
        //test
        ProductionWorker worker = new ProductionWorker("John", "9872-D", "Jan 27/ 2025", 1, 15.5);

        System.out.println(worker.getName());
        System.out.println(worker.getEmployeeNumber());
        System.out.println(worker.getHireDate());
        System.out.println(worker.getShift());;
        System.out.println(worker.getPayRate());

        worker.setName("Bob");
        System.out.println(worker.getName());
        worker.setPayRate(18);
        System.out.println(worker.getPayRate());

    }
}
