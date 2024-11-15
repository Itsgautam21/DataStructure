package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Question : 93
 */
public class RestoreIPAddress {

    private static void restore(String str, List<String> list, int index, String ans, int call) {

        if (index >= str.length() && call < 4) {
            return;
        }
        if (call == 4) {
            if (index == str.length()) {
                list.add(ans.substring(0, ans.length() - 1));
            }
            return;
        }
        // value with one
        int valueOne = Character.getNumericValue(str.charAt(index));
        System.out.println("valueOne - " + valueOne);
        restore(str, list, index + 1, ans + valueOne + ".", call + 1);

        // value with two
        if (valueOne == 0 || index + 1 == str.length()) {
            return;
        }
        int valueTwo = (valueOne * 10) + Character.getNumericValue(str.charAt(index + 1));
        System.out.println("valueTwo - " + valueTwo);
        restore(str, list, index + 2, ans + valueTwo + ".", call + 1);

        // value with three
        if (valueTwo == 0 || index + 2 == str.length()) {
            return;
        }
        int valueThree = (valueTwo * 10) + Character.getNumericValue(str.charAt(index + 2));
        System.out.println("valueThree - " + valueThree);
        if (valueThree > 255) {
            return;
        }
        restore(str, list, index + 3, ans + valueThree + ".", call + 1);
    }

    private static List<String> restoreIpAddresses(String s) {

        List<String> list = new ArrayList<>();
        restore(s, list, 0, "", 0);
        return list;
    }

    public static void main(String[] args) {

        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("101023"));
    }
}
