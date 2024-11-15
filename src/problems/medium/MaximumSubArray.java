package problems.medium;

/**
 * @Question : 53
 */
public class MaximumSubArray {

    private static int maximumSubArray(int[] nums) {

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = sum + num;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {4, 3, -2, 6, -14, 7, 1, 4, 5, 7, -10, 2, 9, -10, -5, -9, 6, 1};
        System.out.println(maximumSubArray(array));

    }
}
