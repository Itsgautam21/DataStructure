package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Question :22
 */
public class GenerateParenthesis {
    
    public static void getGenerateParenthesis(String parenthesis, List<String> ans, int n, int countOpen, int countClose) {
        if (countOpen == n) {
            ans.add(parenthesis + ")".repeat(countOpen - countClose));
            return;
        }
        getGenerateParenthesis(parenthesis + "(", ans, n, countOpen + 1, countClose);
        if (countOpen > countClose)
            getGenerateParenthesis(parenthesis + ")", ans, n, countOpen, countClose + 1);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        getGenerateParenthesis("(", ans, n, 1, 0);
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
