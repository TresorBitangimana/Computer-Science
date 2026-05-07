/**
 * @Author: Tresor Bitangimana
 * @Since: Apr 2/ 2026
 * 
 */

package Assignment10;

import java.util.ArrayList;
//import statements
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * ConllectionFilter class
 * Utility class
 * contaisn static metheds
 */
public class CollectionFilter<T> {

    /**
     * filterList class, a generic class that accepts a list with type <T>,
     * and Predicate condition with type <T> as an argument
     * 
     * @param <T>
     * @param items
     * @param condition
     * @return A filter List of type <T> based on the condition.
     */
    public static <T> List<T> filterList(List<T> items, Predicate<T> condition) {
        return items.stream()
                .filter(condition)
                .collect(Collectors.toList());
    }

    // demo
    public static void main(String[] args) {

        // creates a list "names" of type String and adds 4 names to the list
        List<String> names = new ArrayList<>();
        // adds names to the list
        names.add("John");
        names.add("Aime");
        names.add("Aaron");
        names.add("Tom");
        // creates a predicate with that filters the string if it starts with the letter
        // 'A'
        Predicate<String> condition = s -> s.charAt(0) == 'A';

        System.out.println(names); // prints the original list
        System.out.println(CollectionFilter.filterList(names, condition)); // prints the filtered list.
    }
}
