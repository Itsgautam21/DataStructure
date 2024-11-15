package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Question 90
 */
public class Subset2 {

    public static void combine(int n, int k, int start, int[] array, List<Integer> combine, List<List<Integer>> combinations) {

        if (k == combine.size()) {
            combinations.add(new ArrayList<>(combine));
            return;
        }
        for (int index = start; index <= n - k + combine.size(); index++) {
            // 'if' condition for duplicate elements in array.
            if (index == start || (index > start && array[index] != array[index - 1])) {
                combine.add(array[index]);
                combine(n, k, index + 1, array, combine, combinations);
                combine.remove(combine.size() - 1);
            }
        }
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        // sort for duplicate element.
        Arrays.sort(nums);
        List<List<Integer>> combinations = new ArrayList<>();
        // 'i' is selection in array of length n.
        for (int i = 0; i <= nums.length; i++) {
            combine(nums.length, i, 0, nums, new ArrayList<>(), combinations);
        }
        return combinations;
    }

    public static void main(String[] args) {

        System.out.println(subsets2(new int[]{0}));
        System.out.println(subsets2(new int[]{1, 2, 2}));
        System.out.println(subsets2(new int[]{4, 4, 4, 1, 4}));
    }
}
