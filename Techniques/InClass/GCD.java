package InClass;

public class GCD {
    public static void main(String[] args) {

        int x = 100;
        int y = 20;

        int gcd = 0;

        for (int i = 0; i < x; i++) {
            if (x % y == 0) {
                gcd = y;
            } else {
                gcd = (x % y);
            }
        }

        System.out.println(gcd);

        System.out.println(gcd(10, 5));

    }

    public static int gcd(int x, int y) {
        if (x % y == 0) {
            return y;
        } else {
            return gcd(y, x % y);
        }
    }
}
