/**
 * @author Tresor Bitangimana
 * @since Jan 16 /2026
 */


public class carSimulator {
    public static void main(String[] args){

        FuelGauge fuelGauge = new FuelGauge();

        
        Odometer odometer = new Odometer(fuelGauge);


        //fills the fuel to 15
        for(int i = 0; i < 15; i++){
            fuelGauge.addFuel();
            System.out.println("adding fuel");
        }

        //whiles the car has fuel it runs.
        //adds mileage and for every 24 mileage decrease the fuel by 1
        while(fuelGauge.getFuel() > 0 ){

            odometer.addMileage();

            System.out.println(fuelGauge.toString());
            System.out.println(odometer.toString());

        }

    }
}
