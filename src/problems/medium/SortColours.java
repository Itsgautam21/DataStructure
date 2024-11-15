package problems.medium;

import java.util.Arrays;

/**
 * @Question : 75
 */
public class SortColours {

    /**
     * RED = 0, WHITE = 1, BLUE = 2
     * sort by colours red, white and blue
     *
     * @param nums array of colors
     */
    private static void sortColors(int[] nums) {

        int[] storage = new int[3];
        for (int num : nums) {
            storage[num]++;
        }
        int index = 0;
        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < storage[i]; j++) {
                nums[index] = i;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 0, 2, 1, 1, 0};
        sortColors(array);
        System.out.println(Arrays.toString(array));
    }
}