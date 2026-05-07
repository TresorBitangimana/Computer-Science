/**
 * @author Tresor Bitangimana
 * @since Jan 16 /2026
 */

public class Odometer {
    
    //mileage field to hold the cars mileage
    private int mileage = 0;
    //track the miles per gallon the update the fuelgauge
    private int milesPerGallonTracker = 0;
    // private FuelGauge fuelGauge;
    private FuelGauge fuelGauge;


    Odometer(FuelGauge fuel){
        this.fuelGauge = fuel;
    }

    /**
     * reports the cars mileage.
     * @return milages
     */
    public int getMileage(){
        return mileage;
    }

    /**
     * adds miles to the mileage and updates the fuel gauge
     */
    public void addMileage(){
        if(mileage < 999999){
            //adds 1 to the mileage if its les than 999999.
            mileage++;

            //checks if the miles per gallon reachers 24 to update the fuel gauge.
            if(milesPerGallonTracker == 24){
                //decrease the fuel by 1 
                fuelGauge.useFuel();
                //resets the miles per gallon tracker.
                milesPerGallonTracker = 0;
            }

            //updates the miles per gallon tracker.
            milesPerGallonTracker++;
        }
        else{
            //resets the mileage when it reaches the limit
            mileage = 0;
        }
    }



    public String toString(){
        return "Your cars current mileage is: "+ mileage;
    }
}
