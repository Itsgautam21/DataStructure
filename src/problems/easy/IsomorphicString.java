package problems.easy;

import java.util.HashMap;

public class IsomorphicString {
    /**
     * @Question : 205
     */
    public static boolean isIsomorphic1(String s, String t) {
        
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (map.containsKey(charS) && map.get(charS) != charT)
                return false;
            else map.put(charS, charT);
        }
        return true;
    }
    
    public static boolean isIsomorphic(String s, String t) {
        return isIsomorphic1(s, t) && isIsomorphic1(t, s);
    }
    
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
    
    public static boolean isIsomorphicM2(String s, String t) {
        return transformString(s).equals(transformString(t));
    }
    public static void main(String[] args) {
        System.out.println(isIsomorphic("bacd", "baba"));
        System.out.println(isIsomorphicM2("bcda", "baba"));
    }
}
