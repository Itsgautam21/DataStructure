package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Question : 77
 */
public class Combinations {

    public static void combine(int n, int k, int value, List<Integer> combine, List<List<Integer>> combinations) {

        if (k == combine.size()) {
            combinations.add(new ArrayList<>(combine));
            return;
        }
        for (int i = value; i <= n - k + 1 + combine.size(); i++) {
            combine.add(i);
            combine(n, k, i + 1, combine, combinations);
            combine.remove(combine.size() - 1);
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        combine(n, k, 1, new ArrayList<>(), list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(4, 3));
        System.out.println(combine(5, 2));
        System.out.println(combine(5, 3));
    }
}
