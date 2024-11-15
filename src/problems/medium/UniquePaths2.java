package problems.medium;

import java.util.Arrays;

public class UniquePaths2 {

    /**
     * unique path in obstacle grid
     *
     * @param obstacleGrid m * n grid
     * @param right        right move
     * @param down         down move
     * @param dp           2D matrix DP
     * @return unique paths in grid
     */
    public static int paths(int[][] obstacleGrid, int right, int down, Integer[][] dp) {

        if (right < 1) return 0;
        if (down < 1) return 0;
        if (obstacleGrid[right - 1][down - 1] == 1) return 0;
        if (right == 1 && down == 1) return 1;

        int rightPath;
        if (dp[right - 1][down] == null)
            rightPath = paths(obstacleGrid, right - 1, down, dp);
        else rightPath = dp[right - 1][down];

        int downPath;
        if (dp[right][down - 1] == null)
            downPath = paths(obstacleGrid, right, down - 1, dp);
        else downPath = dp[right][down - 1];
        return dp[right][down] = rightPath + downPath;
    }

    public static int paths(int[][] obstacleGrid) {
        Integer[][] dp = new Integer[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        int value = paths(obstacleGrid, obstacleGrid.length, obstacleGrid[0].length, dp);
        System.out.println(Arrays.deepToString(dp));
        return value;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1}};
        int[][] grid2 = {
                {0, 1},
                {0, 0}};
        int[][] grid3 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        int[][] grid4 = {
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 0}};
        System.out.println(paths(grid1));
        System.out.println(paths(grid2));
        System.out.println(paths(grid3));
        System.out.println(paths(grid4));
    }
}
