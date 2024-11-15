package problems.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem LeetCode [ Sliding window ].
 * <p> Maximum Sum of Distinct SubArrays With Length </p>
 *
 * @Question : 2461
 */
public class MaxSumOfDistinctSubArray {

    private static long maximumSubArraySum(int[] nums, int k) {

        int start = 0;
        int end = 0;
        long sum = 0;
        long max = Long.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        while (end < nums.length) {

            sum = sum + nums[end];
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);

            if (end - start + 1 == k) {
                if (map.size() == k) {
                    max = Math.max(max, sum);
                }
                sum = sum - nums[start];
                if (map.get(nums[start]) == 1) {
                    map.remove(nums[start]);
                } else {
                    map.put(nums[start], map.get(nums[start]) - 1);
                }
                start++;
            }
            end++;
        }
        if (max == Long.MIN_VALUE) {
            return 0L;
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(maximumSubArraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
        System.out.println(maximumSubArraySum(new int[]{4, 4, 4}, 3));
        System.out.println(maximumSubArraySum(new int[]{4, 3, 4, 3}, 2));
    }
}
