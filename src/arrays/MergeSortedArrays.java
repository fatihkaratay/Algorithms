package arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5}, nums2 = {3, 7, 8, 10};
        int[] result = mergeTwoSortedArrays(nums1, nums2);

        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeTwoSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[nums1.length + nums2.length];

        while (i < nums1.length && j < nums2.length)
            if (nums1[i] <= nums2[j])
                result[k++] = nums1[i++];
            else
                result[k++] = nums2[j++];


        while (i < nums1.length)
            result[k++] = nums1[i++];
        while (j < nums2.length)
            result[k++] = nums2[j++];

        return result;
    }
}
