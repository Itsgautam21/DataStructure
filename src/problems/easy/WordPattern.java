package problems.easy;

import java.util.HashMap;

/**
 * @Question :290
 */
public class WordPattern {
    
    public static String transformString(String s) {
        StringBuilder builder = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch))
                map.put(ch, i);
            builder.append(map.get(ch));
        }
        return builder.toString();
    }
    
    public static String transformArray(String[] array) {
        StringBuilder builder = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            String ch = array[i];
            if (!map.containsKey(ch))
                map.put(ch, i);
            builder.append(map.get(ch));
        }
        return builder.toString();
    }
    public static boolean wordPattern(String pattern, String s) {
        String[] array = s.split(" ");
        return transformString(pattern).equals(transformArray(array));
    }
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
