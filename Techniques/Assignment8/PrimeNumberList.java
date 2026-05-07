package Assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PrimeNumberList {
    public static void main(String[] args) {
        List<Integer> primeList = new ArrayList<>();

        // finds all prime number from 1-100 and stole them in the primeList ArrayList.
        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0 && i != j) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                primeList.add(i);
        }
        // adds the list iterater
        ListIterator<Integer> it = primeList.listIterator();

        // iterates through the list.
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
