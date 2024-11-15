package problems.medium;

import java.util.Arrays;

/**
 * @Question 80
 */
public class RemoveDuplicatesFromSortedArray2 {

    private static int removeDuplicates(int[] nums) {

        int count = 1;
        int countElement = 1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count++;
                countElement = 1;
            } else {
                if (countElement < 2) {
                    nums[count] = nums[i];
                    count++;
                }
                countElement++;
            }
        }
        return count;
    }
    private static int removeDuplicatesM2(int[] nums) {

        int count = 0;
        int countElement = 1;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] != nums[i + 1]) {
                nums[count + 1] = nums[i + 1];
                count++;
                countElement = 1;
            } else {
                if (countElement < 2) {
                    nums[count + 1] = nums[i + 1];
                    count++;
                }
                countElement++;
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        int[] array = {-3, -3, -3, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4};
        System.out.println(removeDuplicates(array));
        //System.out.println(removeDuplicatesM2(array));
        System.out.println(Arrays.toString(array));
    }
}
