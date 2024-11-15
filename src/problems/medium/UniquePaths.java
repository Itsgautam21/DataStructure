package problems.medium;

import java.util.Arrays;

public class UniquePaths {

    /**
     * unique paths in grid (top to bottom)
     *
     * @param right right move
     * @param down  down move
     * @param dp    2D matrix DP
     * @return unique possible paths
     */
    public static int uniquePaths(int right, int down, Integer[][] dp) {

        if (right == 1 && down == 1) return 1;
        if (right < 1) return 0;
        if (down < 1) return 0;

        int rightPath;
        if (dp[right - 1][down] == null) {
            rightPath = uniquePaths(right - 1, down, dp);
        } else rightPath = dp[right - 1][down];

        int downPath;
        if (dp[right][down - 1] == null) {
            downPath = uniquePaths(right, down - 1, dp);
        } else downPath = dp[right][down - 1];
        return dp[right][down] = rightPath + downPath;
    }

    public static int uniquePaths(int m, int n) {
        Integer[][] dp = new Integer[m + 1][n + 1];
        int val = uniquePaths(m, n, dp);
        System.out.println(Arrays.deepToString(dp));
        return val;
    }

    /**
     * unique path in the grid (bottom to top)
     *
     * @param right right move
     * @param down  down move
     * @param m     row
     * @param n     column
     * @param dp    2D matrix DP
     * @return unique possible paths
     */
    public static int uniquePathsM2(int right, int down, int m, int n, Integer[][] dp) {

        if (right == m && down == n) return 1;
        if (right > m) return 0;
        if (down > n) return 0;

        int rightPath;
        if (dp[right + 1][down] == null) {
            rightPath = uniquePathsM2(right + 1, down, m, n, dp);
        } else rightPath = dp[right + 1][down];

        int downPath;
        if (dp[right][down + 1] == null) {
            downPath = uniquePathsM2(right, down + 1, m, n, dp);
        } else downPath = dp[right][down + 1];
        return dp[right][down] = rightPath + downPath;
    }

    public static int uniquePathsM2(int m, int n) {
        Integer[][] dp = new Integer[m + 1][n + 1];
        int val = uniquePathsM2(0, 0, m - 1, n - 1, dp);
        System.out.println(Arrays.deepToString(dp));
        return val;
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 2));
        System.out.println(uniquePathsM2(3, 2));
    }
}
