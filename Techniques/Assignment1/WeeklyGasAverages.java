/**
 * @author Tresor Bitangimana
 * @since Jan 16 /2026
 */


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyGasAverages{
    public static void main(String[] args) throws IOException{

        //creates an array list to store all the data from the weekely gas averages
        ArrayList<Double> weeklyGasPrices = new ArrayList<Double>();

        //assigns the weekely_gas_averages file to thescanner object.
        Scanner scanner = new Scanner(new File("Assignment1/1994_Weekly_Gas_Averages.txt"));

        //loops through the Weekely_Gas_Averages file and adds the data to the weeklyGasPrices variable.
        while(scanner.hasNext()){
            weeklyGasPrices.add(Double.parseDouble(scanner.nextLine()));
        }
        
        int smallestIndex = 0;
        double smallest = Double.MAX_VALUE;
        int largestIndex = 0;
        double largest = Double.MIN_VALUE;

        //loops through the arraylist ot find the smallest value
        for(int i = 0; i < weeklyGasPrices.size(); i++){
            //if statement to search for the smallest value in the data set
            if(weeklyGasPrices.get(i) < smallest){
                smallest = weeklyGasPrices.get(i);
                //gets the week of the average
                smallestIndex = i+1;
            }
        }

        //loops through the arraylist to find the largest value
        for(int i = 0; i < weeklyGasPrices.size(); i++){
            //if statement to search for the largest value in the data set
            if(weeklyGasPrices.get(i) > largest){
                largest = weeklyGasPrices.get(i);
                //gets the week of the average
                largestIndex = i+1;
            }
        }

        String smallestWeekMonth = getMonth(smallestIndex);
        String largestWeekMonth = getMonth(largestIndex);


        //prints the results
        System.out.println("The smallest weekly gas average was "+smallest+" in week "+smallestIndex+" in "+smallestWeekMonth);
        System.out.println("The largest weekly gas average was "+largest+" in week "+largestIndex+" in "+ largestWeekMonth);

        //closes the scanner for security.  
        scanner.close();
    }

    /**
     * calculates the month based on the week number given
     * @param week
     * @return month
     */
    public static String getMonth(int week){
        String month = "";

        System.out.println(week);

        if(week >= 1 && week <= 4)
            month = "January";
        else if(week >= 5 && week <= 8)
            month = "February";
        else if(week >= 9 && week <= 13)
            month = "March";
        else if(week >= 14 && week <= 17)
            month = "April";
        else if(week >= 18 && week <= 21)
            month = "May";
        else if(week >= 22 && week <= 26)
            month = "June";
        else if(week >= 27 && week <= 30)
            month = "July";
        else if(week >= 31 && week <= 34)
            month = "August";
        else if(week >= 35 && week <= 39)
            month = "September";
        else if(week >= 40 && week <= 43)
            month = "October";
        else if(week >= 44 && week <= 47)
            month = "November";
        else if(week >= 48 && week <= 52)
            month = "December";

        return month;
    }
}
