package problems.medium;

/**
 * @Question : 91
 */
public class DecodeWays {

    public static int decodeNumber(String str, int index, Integer[] dp) {

        if (index == str.length()) {
            return 1;
        }
        int valueOne = Character.getNumericValue(str.charAt(index));
        System.out.println("value One  - " + valueOne);
        if (valueOne == 0) {
            return 0;
        }
        if (dp[index] != null) {
            return dp[index];
        }
        int countWithOne = decodeNumber(str, index + 1, dp);
        if (index + 1 == str.length()) {
            return dp[index] = countWithOne;
        }
        int valueTwo = Character.getNumericValue(str.charAt(index + 1));
        valueTwo = (valueOne * 10) + valueTwo;
        System.out.println("valueTwo - " + valueTwo);
        if (valueTwo > 26) {
            return dp[index] = countWithOne;
        }
        int countWithTwo = decodeNumber(str, index + 2, dp);
        return dp[index] = countWithOne + countWithTwo;
    }

    public static void main(String[] args) {

        String testcase1 = "06";
        String testcase2 = "226";
        String testcase3 = "111111111111111111111111111111111111111111111";
        System.out.println(decodeNumber(testcase1, 0, new Integer[testcase1.length()]));
        System.out.println(decodeNumber(testcase2, 0, new Integer[testcase2.length()]));
        System.out.println(decodeNumber(testcase3, 0, new Integer[testcase3.length()]));
    }
}
