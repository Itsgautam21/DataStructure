package problems.easy;

import java.util.HashMap;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.get(i) == null ? 1 : map.get(i) + 1);
        for (int item : map.keySet())
            if (map.get(item) == 1) return item;
        return 0;
    }
    public static void main(String[] args) {
        int[] array = {4, 4, 1, 2, 1};
        System.out.println(singleNumber(array));
        
    }
}
