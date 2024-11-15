package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Question : 39
 */
public class CombinationSum {

    /**
     * combination sum
     *
     * @param candidates  candidates
     * @param sum         sum
     * @param target      target
     * @param ans         ans
     * @param combination combination
     */
    private static void combinationSum(int[] candidates, int target, int k, int sum, String combination, List<List<Integer>> ans) {

        if (sum == target) {
            List<Integer> list = new ArrayList<>();
            for (String item : combination.split("-"))
                list.add(Integer.parseInt(item));
            ans.add(list);
            return;
        }
        for (int i = k; i < candidates.length; i++) {
            int newSum = sum + candidates[i];
            if (sum <= target)
                combinationSum(candidates, target, i, newSum, String.format("%s%d-", combination, candidates[i]), ans);
        }
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combinationSum(candidates, target,0, 0, "", list);
        return list;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 5};
        int target = 8;
        System.out.println(combinationSum(array, target));
    }
}
