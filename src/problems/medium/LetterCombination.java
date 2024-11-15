package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Question :17
 */
public class LetterCombination {
    
    public static String getLettersByDigit(char ch) {
        switch (ch) {
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            default: return "";
        }
    }
    
    public static void getLetterCombinations(String[] listOfLetters, List<String> combination, int index, String ans) {
        if (index == listOfLetters.length) {
            combination.add(ans);
            return;
        }
        String digits = listOfLetters[index];
        for (int i = 0; i < digits.length(); i++) {
            getLetterCombinations(listOfLetters, combination, index + 1, ans + digits.charAt(i));
        }
        
    }
    
    public static List<String> letterCombination(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        String[] listOfLetters = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            listOfLetters[i] = getLettersByDigit(digits.charAt(i));
        }
        List<String> combinations = new ArrayList<>();
        getLetterCombinations(listOfLetters, combinations, 0, "");
        return combinations;
    }
    
    public static void main(String[] args) {
        System.out.println(letterCombination("23"));
    }
}
