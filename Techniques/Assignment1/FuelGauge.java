/**
 * @author Tresor Bitangimana
 * @since Jan 16 /2026
 */

public class FuelGauge {

    //fuel field to represents the cars fuel in gallons
    private int fuel = 0;

    /**
     * reports the the amount of fuel.
     * @return fuel
     */
    public int getFuel(){
        return fuel;
    }

    /**
     * adds 1 gallon of fuel to the tank if the fuel is < 15
     * else notifies the user that the fuel is full
     */
    public void addFuel(){
        if(fuel < 15){
            //adds 1 gallon to the fuel
            fuel++;
        }
        else{
            //notifies the user if the fuel is full
            System.out.println("Fuel is full!!!");
        }
    }

    /**
     * removes 1 gallon of fuel from the tank is fuel is > 0
     * simulating the car driving.
     */
    public void useFuel(){
        if(fuel > 0){
            //decrease fuel by 1
            fuel--;
        }
        else{
            System.out.println("You have an empty tank!!!!");
        }
    }

    /**
     * to string method that reportys the current ammount of fuel in the car.
     */
    public String toString(){
        return "You have "+fuel+" gallons of use in the tank";
    }

}