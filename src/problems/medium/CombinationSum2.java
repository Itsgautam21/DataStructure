package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Question : 40
 */
public class CombinationSum2 {

    private static void combinationSum(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> ans) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            combination.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i + 1, combination, ans);
            combination.remove(combination.size() - 1);
        }
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<>(), list);
        return list;
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 2, 1, 2};
        int target = 5;
        System.out.println(combinationSum(array, target));
    }
}
