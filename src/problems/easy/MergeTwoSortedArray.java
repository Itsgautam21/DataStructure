package problems.easy;

import java.util.Arrays;

public class MergeTwoSortedArray {

    public static void mergeTwoSortedArray(int[] nums1, int[] nums2, int m, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 0, 0, 0};
        int[] array2 = {2, 5, 6};
        mergeTwoSortedArray(array1, array2, 3, 3);
        System.out.println(Arrays.toString(array1));
    }


}
