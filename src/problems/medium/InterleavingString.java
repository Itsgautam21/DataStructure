package problems.medium;

import java.util.Arrays;

/**
 * @Question : 97
 */
public class InterleavingString {

    private static boolean isInterleave(String s1, String s2, String s3, int i, int j, int k, Boolean[][][] dp) {

        if (k == s3.length()) {
            return i == s1.length() || j == s2.length();
        }

        if (dp[i][j][k] != null) {
            System.out.printf("i -> %d, j -> %d, k -> %d --> value = %b%n", i, j, k, dp[i][j][k]);
            return dp[i][j][k];
        }

        boolean first = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            first = isInterleave(s1, s2, s3, i + 1, j, k + 1, dp);
        }

        boolean second = false;
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            second = isInterleave(s1, s2, s3, i, j + 1, k + 1, dp);
        }
        return dp[i][j][k] = first || second;
    }

    public static boolean interleaving(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        Boolean[][][] dp = new Boolean[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        boolean value = isInterleave(s1, s2, s3, 0, 0, 0, dp);
        System.out.println(Arrays.deepToString(dp));
        return value;
    }

    public static void main(String[] args) {

        System.out.println(interleaving("aa", "ab", "aaba"));
    }
}
