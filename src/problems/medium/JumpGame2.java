package problems.medium;

import java.util.Arrays;

/**
 * @Question :45
 */
public class JumpGame2 {

    public static int jump(int[] array, int value, int index, int[] dp) {

        if (index == array.length - 1) {
            return 0;
        }

        int minStep = Integer.MAX_VALUE;
        for (int i = 0; i < value; i++) {

            int newIndex = index + i + 1;
            if (newIndex < array.length) {

                int step = Integer.MAX_VALUE;
                if (dp[newIndex] == 0) {
                    step = jump(array, array[newIndex], newIndex, dp);
                    if (step != Integer.MAX_VALUE) {
                        step = step + 1;
                    }
                } else {
                    if (dp[newIndex] != Integer.MAX_VALUE) {
                        step = 1 + dp[newIndex];
                    }
                }
                minStep = Math.min(minStep, step);
            }
        }
        dp[index] = minStep;
        return minStep;
    }

    public static int jump(int[] array) {
        int[] dp = new int[array.length];
        int value = jump(array, array[0], 0, dp);
        System.out.println(Arrays.toString(dp));
        return value;
    }

    public static void main(String[] args) {
        int[] testCase1 = {5, 2};
        int[] testCase2 = {3, 2, 1, 0, 4};
        int[] testCase3 = {2, 3, 0, 1, 4};
        System.out.println(jump(testCase1));
        System.out.println(jump(testCase2));
        System.out.println(jump(testCase3));
    }
}
