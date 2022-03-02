package arrays;

import java.util.Arrays;

/**
 * Removing duplicate characters from the array
 *
 * example:
 * str = "a***b**c" --> "a*b*c"
 *
 * using both extra space and modifying the array are implemented.
 */

public class ExtraCharDecreaser {
    public static void main(String[] args) {
        String str = "a**b***c"; // "a*b*c"

        extraDupCharRemoverSpace(str);
        System.out.println(extraDupCharRemover(str));
    }

    public static void extraDupCharRemoverSpace(String str) {
        char[] pattern = str.toCharArray();
        int index = 0;
        boolean isFirst = true;

        for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[index++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[index++] = pattern[i];
                isFirst = true;
            }
        }

        for (int i = 0; i < index; i++)
            System.out.print(pattern[i]);
        System.out.println();
    }

    public static String extraDupCharRemover(String str) {
        return null;
    }
}
