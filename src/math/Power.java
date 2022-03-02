package math;

/**
 * computing the power of any numbers.
 * We have both recursive and iterative way.
 * Also, we have bit-manipulation approach for the really large and negative numbers.
 */

public class Power {

    public static void main(String[] args) {
        int a = 5, b = 4;

        System.out.println(powerRec(a, b));
        System.out.println(powerItr(a, b));
        System.out.println(power(a, b));
    }

    public static int powerRec(int a, int b) {
        // base case
        if (b == 0)
            return 1;
        int temp = powerRec(a, b / 2);
        int result = temp * temp;
        if (b % 2 == 1)
            result *= a;

        return result;
    }

    public static int powerItr(int a, int b) {
        int result = 1;

        while (b > 0) {
            if (b % 2 == 1)
                result *= a;
            a *= a;
            b /= 2;
        }

        return result;
    }

    public static double power(int x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double ans = 1;
        double currentProduct = x;

        for (long i = N; i > 0; i = i/2) {
            if (i % 2 == 1)
                ans = currentProduct * ans;
            currentProduct = currentProduct * currentProduct;
        }
        return ans;
    }
}
