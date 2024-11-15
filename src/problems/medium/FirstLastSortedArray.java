package problems.medium;

import java.util.Arrays;

/**
 * @Question : 34
 */
public class FirstLastSortedArray {

    public static int[] searchRange(int[] nums, int target) {

        int l = binarySearch(nums, target);
        if (l == nums.length || nums[l] != target) return new int[]{-1, -1};
        int r = binarySearch(nums, target + 1);
        return new int[]{l, r - 1};
    }

    private static int binarySearch(int[] nums, int target) {

        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }

    public static void main(String[] args) {

        int[] array = {5, 6, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(array, 8)));
    }
}
