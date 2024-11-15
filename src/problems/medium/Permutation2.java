package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Question : 47
 */
public class Permutation2 {

    private static void permutation(int[] array, List<Integer> combination, List<List<Integer>> permutation) {

        if (array.length == 0) {
            permutation.add(new ArrayList<>(combination));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1 && array[i] == array[i + 1]) continue;
            int[] subArray = new int[array.length - 1];
            for (int j = 0; j < i; j++)
                subArray[j] = array[j];
            for (int j = i; j < subArray.length; j++)
                subArray[j] = array[j + 1];

            combination.add(array[i]);
            permutation(subArray, combination, permutation);
            combination.remove(combination.size() - 1);
        }
    }

    private static List<List<Integer>> permutation(int[] nums) {
        List<List<Integer>> permutation = new ArrayList<>();
        Arrays.sort(nums);
        permutation(nums, new ArrayList<>(), permutation);
        return permutation;
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2};
        System.out.println(permutation(array));
    }
}
