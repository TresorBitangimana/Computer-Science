package InClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CsvReader {
    public static void main(String[] args) throws FileNotFoundException{

        StringBuilder string = new StringBuilder("I ate 100 bluebaries");

        // string.deleteCharAt(6);
        System.out.println(string);
        
        System.out.println(Integer.MIN_VALUE);


        File file = new File("InClass/Testing.csv");

        Scanner input = new Scanner(file);

        while(input.hasNext()){
            System.out.println(input.nextLine().charAt(1));
            System.out.println();
        }

        // input.
        input.close();
    }
}
