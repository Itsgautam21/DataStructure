package problems.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem GFG [sliding window]
 * <p>Count Occurrences of Anagrams</p>
 *
 * @Question : 3
 */
public class CountOccurrencesOfAnagrams {

    private static int countOccurrencesOfAnagrams(String pat, String txt) {

        Map<Character, Integer> pMap = new HashMap<>();
        for (char ch : pat.toCharArray()) {
            pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> textMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int count = 0;
        while (end < txt.length()) {

            char ch = txt.charAt(end);
            textMap.put(ch, textMap.getOrDefault(ch, 0) + 1);
            if (end - start + 1 == pat.length()) {
                if (pMap.equals(textMap)) {
                    count++;
                }
                char firstChar = txt.charAt(start);
                if (textMap.get(firstChar) == 1) {
                    textMap.remove(firstChar);
                } else {
                    textMap.put(firstChar, textMap.get(firstChar) - 1);
                }
                start++;
            }
            end++;
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(countOccurrencesOfAnagrams("for", "forxxorfxdofr"));
        System.out.println(countOccurrencesOfAnagrams("aaba", "aabaabaa"));
    }
}
