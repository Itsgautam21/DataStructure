package problems.sliding_window;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem Interview Bit
 * <p>Sliding Window Maximum</p>
 *
 * @Question : 4
 */
public class MaxNumberInAllSubArray {

    private static int[] maxNumberInAllSubArray(int[] nums, int k) {

        int start = 0;
        int end = 0;
        int index = 0;
        int[] ans = new int[nums.length - k + 1];
        List<Integer> maximums = new ArrayList<>();

        while (end < nums.length) {

            int value = nums[end];
            maximums = maximums.stream().filter(m -> m >= value).collect(Collectors.toList());
            maximums.add(nums[end]);
            if (end - start + 1 == k) {
                ans[index] = maximums.get(0);
                if (nums[start] == maximums.get(0)) {
                    maximums.remove(0);
                }
                index++;
                start++;
            }
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] array = {268, 202, 139, 744, 502, 582, 94, 81, 117, 258, 506, 461, 531, 768, 827, 128, 592, 571, 559, 374, 910, 610, 561, 489, 647, 246, 355, 313, 158, 922, 557, 36, 430, 983, 913, 303, 765, 945, 167, 340, 869, 869, 609, 809, 529, 715, 34, 13, 657, 407, 684, 801, 129, 952, 159, 250, 546, 508, 540, 948, 429, 174};
        System.out.println(Arrays.toString(maxNumberInAllSubArray(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxNumberInAllSubArray(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 2)));
        System.out.println(Arrays.toString(maxNumberInAllSubArray(new int[]{268, 202, 139, 744, 502, 582, 94, 81, 117, 258, 506, 461, 531, 768, 827, 128, 592, 571, 559, 374, 910, 610, 561, 489, 647, 246, 355, 313, 158, 922, 557, 36, 430, 983, 913, 303, 765, 945, 167, 340, 869, 869, 609, 809, 529, 715, 34, 13, 657, 407, 684, 801, 129, 952, 159, 250, 546, 508, 540, 948, 429, 174}, 6)));

        Map<Integer, Integer> map = new HashMap<>();
        for (int item : array) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}
