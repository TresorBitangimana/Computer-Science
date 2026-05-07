package InClass;

import java.util.ArrayList;
import java.util.function.Predicate;

public class MR{

    public static void main(String[] args) {
        
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(10));


        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);


        numbers.forEach(System.out::println);

    }
}