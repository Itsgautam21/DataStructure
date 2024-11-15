package problems.easy;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Question : 20
 */
public class ValidParentheses {

    private static char oppositeChar(char ch) {
        switch (ch) {
            case ')': return '(';
            case ']': return '[';
            case '}': return '{';
            default: return '!';
        }
    }
    private static boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else if (stack.isEmpty() || stack.pop() != oppositeChar(ch)) return false;
        }
        return stack.isEmpty();
    }
    private static boolean validParenthesesM2(String s) {

        char[] array = new char[s.length()];
        int pointer = -1;
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                pointer++;
                array[pointer] = ch;
            } else if (pointer == -1 || array[pointer] != oppositeChar(ch)) {
                return false;
            } else pointer--;
        }
        System.out.println(Arrays.toString(array));
        return pointer == -1;
    }

    public static void main(String[] args) {

        String testCase1 = "{{[]}}()";
        String testCase2 = "{[()][]}[]{{[()]}}{}";
        System.out.println(validParentheses(testCase2));
        System.out.println(validParenthesesM2(testCase1));
    }
}
