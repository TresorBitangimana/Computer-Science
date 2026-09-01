import java.util.Arrays;

public class RecursionReview {
    public static void main(String[] args) {
        // String str = "1234567890";
        // System.out.println(stringToInt(str));

        int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        evenOdds(nums);

    }

    public static int stringToInt(String str) {

        if (str.length() == 0)
            return 0;

        char last = str.charAt(str.length() - 1);
        int digit = last - '0';
        String others = str.substring(0, str.length() - 1);
        return 10 * stringToInt(others) + digit;

    }

    // rearrage array 2, so that all even #s come before all odd #

    public static void evenOdds(int[] array) {
        int[] results = rearrage(array, 0, array.length - 1);
        System.out.println(Arrays.toString(results));
    }
    public static int[] rearrage(int[] array, int left, int right) {

        if (left >= right) return array;
        if (array[left] % 2 == 0) return rearrage(array, left + 1, right);
        if (array[right] % 2 != 0) return rearrage(array, left, right - 1);
        
        int temp = array[right];
        array[right] = array[left];
        array[left] = temp;
        return rearrage(array, left + 1, right - 1);
    }
}
