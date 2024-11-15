package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Question : 78
 */
public class Subsets {

    public static void combine(int n, int k, int start, int[] array, List<Integer> combine, List<List<Integer>> combinations) {

        if (k == combine.size()) {
            combinations.add(new ArrayList<>(combine));
            return;
        }
        for (int index = start; index <= n - k + combine.size(); index++) {
            combine.add(array[index]);
            combine(n, k, index + 1, array, combine, combinations);
            combine.remove(combine.size() - 1);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<>();
        // 'i' is selection in array of length n.
        for (int i = 0; i <= nums.length; i++) {
            combine(nums.length, i, 0, nums, new ArrayList<>(), combinations);
        }
        return combinations;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{1, 2, 3, 4}));
        System.out.println(subsets(new int[]{1, 2, 3, 4, 5}));
    }
}
