package problems.easy;

public class LongestCommonPrefix {

    public static String getMaxPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (String s : strs) minLength = Math.min(minLength, s.length());
        String ans = "";
        for (int i = 0; i < minLength; i++) {
            int index = 0;
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    index = 1;
                    break;
                }
            }
            if (index == 0) ans = ans + strs[0].charAt(i);
            else break;
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] testCase1 = {"flex", "fleet", "floor"};
        String[] testCase2 = {"flex", "flex", "flop"};
        String[] testcase3 = {"cow", "fan", "sky"};
        System.out.println(getMaxPrefix(testCase1));
    }
}
