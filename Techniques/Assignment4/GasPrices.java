package Assignment4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GasPrices {
    public static void main(String[] args) throws IOException{
        
        File file = new File("Assignment4/GasPrices.txt");
        Scanner scanner = new Scanner(file);

        // averagePricePerYear(scanner);
        // averagePricePerMonth(scanner);
        // highestAndLowestPricesPerYear(scanner);
        // lowestToHighest(scanner);
        // highestToLowest(scanner);

        scanner.close();
    }

    

    public static HashMap<String, Double> getAverageYearAndPrice(Scanner input){


        HashMap<String, Double> data = new HashMap<>();
        HashMap<String, Integer> tracker = new HashMap<>();
        ArrayList<String> years = new ArrayList<>();

        while(input.hasNext()){
            String currInput = input.next();

            String currYear = currInput.substring(6,10);
            String currPrice = currInput.substring(11);
            double currPriceDouble = Double.parseDouble(currPrice);

            if(!(data.containsKey(currYear))){
                data.put(currYear, currPriceDouble);
                tracker.put(currYear, 1);
                years.add(currYear);
            }
            else{
                data.put(currYear, data.get(currYear)+currPriceDouble);
                tracker.put(currYear, tracker.get(currYear)+1);
            }
        }

        for(int i = 0; i < years.size();i++){
            String yearToUpdate = years.get(i);
            data.put(yearToUpdate, data.get(yearToUpdate)/tracker.get(yearToUpdate));
        }

        return data;
    }

    public static void averagePricePerYear(Scanner input) {

        HashMap<String, Double> data = getAverageYearAndPrice(input);

        //printed format
        for (Map.Entry<String, Double> entry : data.entrySet()) {

            System.out.println("Year: "+entry.getKey()+", Average Price: "+entry.getValue());
        }
    }

    public static void averagePricePerMonth(Scanner input){

        HashMap<String, Double> data = new HashMap<>();
        HashMap<String, Integer> tracker = new HashMap<>();
        ArrayList<String> months = new ArrayList<>();

        while(input.hasNext()){

            String currInput = input.next();

            String currMonthAndMonth = currInput.substring(0,2)+"-"+currInput.substring(6,10);
            String currPrice = currInput.substring(11);
            double currPriceDouble = Double.parseDouble(currPrice);

            if(!(data.containsKey(currMonthAndMonth))){
                data.put(currMonthAndMonth, currPriceDouble);
                tracker.put(currMonthAndMonth, 1);
                months.add(currMonthAndMonth);
            }
            else{
                data.put(currMonthAndMonth, data.get(currMonthAndMonth)+currPriceDouble);
                tracker.put(currMonthAndMonth, tracker.get(currMonthAndMonth)+1);
            }
        }

        for(int i = 0; i < months.size();i++){
            String monthToUpdate = months.get(i);
            data.put(monthToUpdate, data.get(monthToUpdate)/tracker.get(monthToUpdate));
        }

        //printed format
        for (Map.Entry<String, Double> entry : data.entrySet()) {

            System.out.println("Month and year: "+entry.getKey()+", Average Price: "+entry.getValue());
        }
    }

    public static void highestAndLowestPricesPerYear(Scanner input){

        ArrayList<String> years = new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();

        while(input.hasNext()){
            String currInput = input.next();

            String currDate = currInput.substring(0,10);
            String currPrice = currInput.substring(11);
            double currPriceDouble = Double.parseDouble(currPrice);

            years.add(currDate);
            prices.add(currPriceDouble);
        }

        int year = 1993;
        double lowestYearPrice = Double.MAX_VALUE;
        String lowestYear = "";
  
        System.out.println("============== Lowest of the year ==========");
        for(int i = 0; i < years.size(); i++){

            //for lowest of the year
            if(years.get(i).substring(6,10).equals(String.valueOf(year))){
                if(prices.get(i) < lowestYearPrice){
                    lowestYearPrice = prices.get(i);
                    lowestYear = years.get(i);
                }
            }else{
                System.out.println(lowestYear +" "+ lowestYearPrice);
                lowestYearPrice = Double.MAX_VALUE;
                lowestYear = "";
                year++;
            }
        }

        System.out.println("============== highest of the year ==========");

        year = 1993;
        double highestYearPrice = Double.MIN_VALUE;
        String highestYear = "";

        for(int i =0; i < years.size(); i++){
            //for highest of the year
            if(years.get(i).substring(6,10).equals(String.valueOf(year))){
                if(prices.get(i) > highestYearPrice){
                    highestYearPrice = prices.get(i);
                    highestYear = years.get(i);
                }
            }else{
                System.out.println(highestYear +": "+ highestYearPrice);
                highestYearPrice = Double.MIN_VALUE;
                highestYear = "";
                year++;
            }
        }


    }

    public static void lowestToHighest(Scanner input) throws IOException{

        HashMap<String, Double> data = new HashMap<>();
        
        FileWriter fileWriter = new FileWriter("Assignment4/lowest_to_highest_prices.txt", true);
        PrintWriter writer = new PrintWriter(fileWriter);

        while(input.hasNext()){
            String currInput = input.next();

            String currYear = currInput.substring(0,11);
            String currPrice = currInput.substring(11);
            double currPriceDouble = Double.parseDouble(currPrice);

            data.put(currYear, currPriceDouble);
        }

        double lowest = Double.MAX_VALUE;
        String lowestYear = "";


        for(int i =0; i < data.size(); i++){
            for(Map.Entry<String, Double> entry : data.entrySet()){
                if(entry.getValue() < lowest){
                    lowest = entry.getValue();
                    lowestYear = entry.getKey();
                }
            }   
            // System.out.println(lowestYear + lowest);
            writer.println(lowestYear + lowest);
            data.remove(lowestYear);
            lowest = Double.MAX_VALUE;
        }

        writer.close();
    }

    public static void highestToLowest(Scanner input) throws IOException{

        HashMap<String, Double> data = new HashMap<>();
        
        FileWriter fileWriter = new FileWriter("Assignment4/lhighest_to_lowest_prices.txt", true);
        PrintWriter writer = new PrintWriter(fileWriter);

        while(input.hasNext()){
            String currInput = input.next();

            String currYear = currInput.substring(0,11);
            String currPrice = currInput.substring(11);
            double currPriceDouble = Double.parseDouble(currPrice);

            data.put(currYear, currPriceDouble);
        }

        double highest = Double.MIN_VALUE;
        String highestYear = "";


        for(int i =0; i < data.size(); i++){
            for(Map.Entry<String, Double> entry : data.entrySet()){
                if(entry.getValue() > highest){
                    highest = entry.getValue();
                    highestYear = entry.getKey();
                }
            }   
            // System.out.println(lowestYear + lowest);
            writer.println(highestYear + highest);
            data.remove(highestYear);
            highest = Double.MIN_VALUE;
        }

        writer.close();
    }
}
