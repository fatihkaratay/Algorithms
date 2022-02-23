package dp;

import java.util.Arrays;

/**
 * Longest Increasing Subsequence: Given an array of integers, find the length of the longest increasing subsequence.
 * For e.g, in [1, 3, 2, 5, 3, 5, 6], the longest increasing subsequence is [1, 2, 3, 5, 6] of length 5
 */

public class LongestIncreasingSubsequent {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 2, 5, 3, 5, 6};

        System.out.println(longestIncreasingSebsequent(nums1));
    }

    public static int longestIncreasingSebsequent(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            dp[i] = 1;
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            res = Math.max(res, dp[i]); // finding the max of the array till index = i
        }

        System.out.println("DP[]: " + Arrays.toString(dp));
        return res;
    }
}
