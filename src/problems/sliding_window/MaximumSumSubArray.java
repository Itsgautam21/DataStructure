package problems.sliding_window;

/**
 * Problem GFG [sliding window]
 * <p>Maximum sum in all sub array </p>
 *
 * @Question : 1
 */
public class MaximumSumSubArray {

    private static int maximumSumSubArray(int[] nums, int k) {

        int start = 0;
        int end = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (end < nums.length) {

            sum = sum + nums[end];
            if (end - start + 1 == k) {
                max = Math.max(max, sum);
                sum = sum - nums[start];
                start++;
            }
            end++;
        }
        if (max == Integer.MIN_VALUE) {
            return 0;
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(maximumSumSubArray(new int[]{4, 5, 6, 2, 3}, 2));
        System.out.println(maximumSumSubArray(new int[]{4, 5, 6, 2, 3}, 3));
    }
}
