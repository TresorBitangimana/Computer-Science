/**
 * @Author Tresor Bitangimana
 * @since Feb 8/26
 * backword string class, thats reverses a string.
 */
package Assignment4;

// requires packages
import java.util.Scanner;

public class Backword {
//Main method
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String string = scanner.nextLine();
        scanner.close();

        System.out.println(reverseString(string));
    }

    /**
     * reverseString method, accepts a string as an argument.
     * @param string
     * @return new reversed String.
     */
    public static String reverseString(String string){

        StringBuilder newString = new StringBuilder(string);
        newString.reverse();

        return newString.toString();
    }

}
