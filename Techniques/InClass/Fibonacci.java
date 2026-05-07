package InClass;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {

        int fibLength = 10;
        int[] fibArr = new int[fibLength];

        // with for loop
        for (int i = 0; i < fibArr.length; i++) {
            if (i == 0) {
                fibArr[i] = 1;
            } else if (i == 1) {
                fibArr[i] = 1;
            } else {
                fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
            }
        }

        System.out.println(Arrays.toString(fibArr));

        // with recursion
        System.out.println(fib(9));

    }

    public static int fib(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
