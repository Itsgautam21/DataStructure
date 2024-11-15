package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Question : 46
 */
public class Permutation {

    private static void permutation(int[] array, List<Integer> combination, List<List<Integer>> permutation) {

        if (array.length == 0) {
            permutation.add(new ArrayList<>(combination));
            return;
        }
        for (int i = 0; i < array.length; i++) {
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
        permutation(nums, new ArrayList<>(), permutation);
        return permutation;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        System.out.println(permutation(array));
    }
}
