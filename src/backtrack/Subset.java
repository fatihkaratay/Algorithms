package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3}; // distinct
        int[] nums2 = {1, 2, 2}; // contains duplicate.

        List<List<Integer>> res1 = printAllCombinations(nums1);
        List<List<Integer>> res2 = printAllCombinationsDup(nums2);

        System.out.println(res1);
        System.out.println(res2);
    }

    public static List<List<Integer>> printAllCombinations(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList(), 0);

        return res;
    }

    private static void backtrack(int[] nums, List<List<Integer>> result, ArrayList<Integer> memo, int start) {
        result.add(new ArrayList<>(memo));

        for (int i = start; i < nums.length; i++) {
            memo.add(nums[i]);
            backtrack(nums, result, memo, i + 1);
            memo.remove(memo.size() - 1);
        }
    }

    public static List<List<Integer>> printAllCombinationsDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrackDup(nums, res, new ArrayList(), new boolean[nums.length], 0);

        return res;
    }

    private static void backtrackDup(int[] nums, List<List<Integer>> res, ArrayList memo, boolean[] used, int start) {
        res.add(new ArrayList<>(memo));

        for (int i = start; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i-1] == nums[i] && !used[i-1]) continue;
            memo.add(nums[i]);
            used[i] = true;
            backtrackDup(nums, res, memo, used, i + 1);
            used[i] = false;
            memo.remove(memo.size() - 1);
        }
    }
}
