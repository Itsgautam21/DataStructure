package problems.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem GFG [sliding window]
 * <p>First negative integer in every window of size k</p>
 *
 * @Question : 2
 */
public class FirstNegativeNumInSubArray {

    private static long[] firstNegativeNumInSubArray(long[] nums, int k) {

        int start = 0;
        int end = 0;
        int index = 0;
        List<Long> negatives = new ArrayList<>();
        long[] ans = new long[nums.length - k + 1];
        while (end < nums.length) {

            if (nums[end] < 0) {
                negatives.add(nums[end]);
            }
            if (end - start + 1 == k) {
                if (negatives.isEmpty()) {
                    ans[index] = 0;
                } else {
                    ans[index] = negatives.get(0);
                    if (nums[start] < 0) negatives.remove(0);
                }
                index++;
                start++;
            }
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(firstNegativeNumInSubArray(new long[]{12, -1, -7, 8, -15, 30, 16, 28}, 3)));
        System.out.println(Arrays.toString(firstNegativeNumInSubArray(new long[]{12, -1, -7, 8, -15, 30, 16, 28}, 2)));
    }
}
