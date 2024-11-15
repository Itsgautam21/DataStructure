package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Question : 49
 */
public class GroupAnagrams {

    /**
     * signature of the string to check anagram (converted into char and its count e.g. a4d3s2 )
     *
     * @param string string
     * @return signature of the string.
     */
    private static String getSignature(String string) {

        int[] array = new int[26];
        for (int i = 0; i < string.length(); i++) {
            array[string.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0)
                builder.append((char) (i + 'a')).append(array[i]);
        }
        return builder.toString();
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> group = new ArrayList<>();
        for (String str : strs) {
            map.putIfAbsent(getSignature(str), new ArrayList<>());
            map.get(getSignature(str)).add(str);
        }
        for (String key : map.keySet()) {
            group.add(map.get(key));
        }
        return group;
    }

    /**
     * group repeated elements in an array.
     *
     * @param array array
     */
    private static void groupRepeatedElements(int[] array) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int item : array) {
            map.putIfAbsent(item, new ArrayList<>());
            map.get(item).add(item);
        }
        System.out.println(map);
    }

    public static void main(String[] args) {
        String[] array = {"bat", "ant", "nat", "hat", "aht", "tab"};
        System.out.println(groupAnagrams(array));
        int[] numbers = {1, 1, 1, 2, 2, 4, 4, 5, 5, 6, 1, 2, 3};
        groupRepeatedElements(numbers);
    }
}
