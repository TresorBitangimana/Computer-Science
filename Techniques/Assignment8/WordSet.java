/**
 * @Author Tresor Bitangimana
 * @Since March 24
 */

package Assignment8;

//required import statement
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * WordSet class, takes a sentance from the user and return
 * a LinkedHashSet of each unique word in that sentence
 */
public class WordSet {
    /**
     * mian method
     * 
     * @param args
     */
    public static void main(String[] args) {

        LinkedHashSet<String> list = new LinkedHashSet<>(); // creates a LinkedHashset instance that
                                                            // accepts Strings its argumanets
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String line = scanner.nextLine();
        scanner.close();

        String[] lineToken = line.split(" "); // splits the line into tokens

        for (int i = 0; i < lineToken.length; i++) {
            list.add(lineToken[i]);
        }
        System.out.println(list); // prints the tokenized line with only unique elements

    }
}
