/**
 * @author Tresor Bitangimana
 * @since Jan 16 /2026
 */

public class Car {
    
    //private field for the year model
    private int yearModel;
    //private field for the make;
    private String make;
    //private field for the speed
    private int speed;

    /**
     * Constructor method, that sets the year model and make the the methods peramiters
     * @param y
     * @param m
     */
    public Car(int y, String m){
        yearModel = y;
        make = m;
        speed = 0;
    }

    /**
     * setter method for the year model
     * @param y
     */
    public void setYearModel(int y){
        yearModel = y;
    }

    /**
     * setter method for the make
     * @param m
     */
    public void setMake(String m){
        make = m;
    }

    /**
     * setter method for the speed
     * @param s
     */
    public void setSpeed(int s){
        speed = s;
    }

    /**
     * getter method for the yeear model
     * @return yearModel
     */
    public int getYearModel(){
        return yearModel;
    }

    /**
     * getter method for the make
     * @return make
     */
    public String getMake(){
        return make;
    }

    /**
     * getter methdo for the speed
     * @return speed
     */
    public int getSpeed(){
        return speed;
    }

    /**
     * accelerate method, accelereates by increasing the speed by 5;
     */
    public void accelerate(){
        speed += 5;
    }

    /**
     * break,m method, breakes by decreasing the speed by 5;
     */
    public void brake(){
        speed -= 5;
    }

    public static void main(String[] args){

        Car car = new Car(2008, "Honda Accord");

        //car speed 
        int carSpeed = 0;

        //accelerates the car five times
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();
        car.accelerate();

        //gets the car speed
        carSpeed = car.getSpeed();
        //display the car speed
        System.out.println(carSpeed);

        //brakes the car five times
        car.brake();
        car.brake();
        car.brake();
        car.brake();
        car.brake();

        //gets the cars speed
        carSpeed = car.getSpeed();
        //displays the car speed
        System.out.println(carSpeed);


    }

}
