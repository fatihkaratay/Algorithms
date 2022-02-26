package backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 1, 5};
        int[] nums3 = {1, 5, 8, 4, 7, 6, 5, 3, 1};

        List<List<Integer>> res1 = printAllPermutations(nums1);
        List<List<Integer>> res2 = printAllPermutationsDup(nums2); // contains duplicate.
        List<List<Integer>> res3 = printAllPermutationsDup(nums3); // contains duplicate

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }

    public static List<List<Integer>> printAllPermutationsDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrackDup(nums, res, new ArrayList(), new boolean[nums.length]);

        return res;
    }
    private static void backtrackDup(int[] nums, List<List<Integer>> res,ArrayList memo, boolean[] used) {
        if (memo.size() == nums.length) {
            res.add(new ArrayList<>(memo));

            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && !used[i-1] && nums[i-1] == nums[i]) continue;
                memo.add(nums[i]);
                used[i] = true;
                backtrackDup(nums, res, memo, used);
                used[i] = false;
                memo.remove(memo.size() - 1);
            }
        }
    }

    public static List<List<Integer>> printAllPermutations(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, new ArrayList());

        return res;
    }

    private static void backtrack(int[] nums, List<List<Integer>> res, ArrayList memo) {
        if (memo.size() == nums.length) {
            res.add(new ArrayList<>(memo));

            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (memo.contains(nums[i])) continue;
                memo.add(nums[i]);
                backtrack(nums, res, memo);
                memo.remove(memo.size() - 1);
            }
        }
    }
}
