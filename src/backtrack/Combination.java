package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 * You may return the answer in any order.
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */

public class Combination {
    public static void main(String[] args) {
        int n1 = 4, k1 = 2;
        int n2 = 1, k2 = 1;

        System.out.println(printAllCombinations(n1, k1));
        System.out.println(printAllCombinations(n2, k2));
    }

    public static List<List<Integer>> printAllCombinations(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = i+1;

        backtrack(nums, res, new ArrayList(), k, 0);
        return res;
    }

    private static void backtrack(int[] nums, List<List<Integer>> res, ArrayList memo, int k, int start) {
        if (memo.size() == k) {
            res.add(new ArrayList<>(memo));
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                memo.add(nums[i]);
                backtrack(nums, res, memo, k, i+1);
                memo.remove(memo.size() - 1);
            }
        }

    }

}
