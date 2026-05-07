package Assignment13;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(multiply(10, 0));
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(isMember(numbers, 3, 0));
        reverseString("Hello World!!!");
        System.out.println(maxElement(numbers));
        System.out.println(raise(2, 0));
        System.out.println(sumOfInt(4));

    }

    // challenge 1
    public static double multiply(double x, double y) {
        if (x == 0 || y == 0) {
            return 0;
        } else {
            return x + multiply(x, y - 1);
        }
    }

    // challenge 2
    public static boolean isMember(int[] list, int target, int index) {

        if (index >= list.length) {
            return false;
        } else if (list[index] == target) {
            return true;
        } else {
            return isMember(list, target, index + 1);
        }
    }

    // challenge 3
    public static void reverseString(String str) {

        if (str.length() == 0) {
            return;
        }
        System.out.print(str.charAt(str.length() - 1));
        reverseString(str.substring(0, str.length() - 1));

    }

    // challenge 4
    public static int maxElement(int[] array) {

        if (array.length == 1) {
            return array[0];
        }

        int max = maxElement(Arrays.copyOfRange(array, 1, array.length));

        if (array[0] > max) {
            return array[0];
        } else {
            return max;
        }
    }

    // challenge 7
    public static int raise(int x, int expo) {
        if (expo == 0) {
            return 1;
        }
        return x * raise(x, expo - 1);
    }

    // challenge 8
    public static int sumOfInt(int x) {
        if (x == 0) {
            return 0;
        }
        return x + sumOfInt(x - 1);
    }
}
