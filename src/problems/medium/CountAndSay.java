package problems.medium;

/**
 * @Question 38
 */
public class CountAndSay {

    /**
     * count and say string.
     *
     * @param n n
     * @return digit string of count and say.
     */
    private static String countAndSay(int n) {

        if (n == 1) return "1";
        String str = countAndSay(n - 1);
        String digitString = "";
        int countDigit = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                digitString = String.format("%s%d%c", digitString, countDigit, str.charAt(i));
                countDigit = 1;
            } else countDigit++;
        }
        digitString = String.format("%s%d%c", digitString, countDigit, str.charAt(str.length() - 1));
        return digitString;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
