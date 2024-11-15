package problems.medium;

import java.util.Arrays;

/**
 * @Question : 64
 */
public class MinimumPathSum {

    /**
     * minimum path sum in grid (recursion)
     *
     * @param grid  grid m * n
     * @param right right move
     * @param down  down move
     * @return min sum path
     */
    private static int minimumPathSum(int[][] grid, int right, int down) {

        if (right < 1) return Integer.MAX_VALUE;
        if (down < 1) return Integer.MAX_VALUE;

        if (right == 1 && down == 1)
            return grid[right - 1][down - 1];

        int rightPathSum = minimumPathSum(grid, right, down - 1);
        int downPathSum = minimumPathSum(grid, right - 1, down);
        return grid[right - 1][down - 1] + Math.min(rightPathSum, downPathSum);
    }

    private static int minimumPathSum(int[][] grid) {
        return minimumPathSum(grid, grid.length, grid[0].length);
    }

    /**
     * minimum path sum in grid (DP)
     *
     * @param grid  grid
     * @param right right move
     * @param down  down move
     * @param dp    2D array DP
     * @return min path sum
     */
    private static int minimumPathSumDP(int[][] grid, int right, int down, Integer[][] dp) {

        if (right < 1) return Integer.MAX_VALUE;
        if (down < 1) return Integer.MAX_VALUE;

        if (right == 1 && down == 1) {
            return grid[right - 1][down - 1];
        }

        int rightPathSum;
        if (dp[right][down - 1] == null) {
            rightPathSum = minimumPathSumDP(grid, right, down - 1, dp);
        } else rightPathSum = dp[right][down - 1];

        int downPathSum;
        if (dp[right - 1][down] == null) {
            downPathSum = minimumPathSumDP(grid, right - 1, down, dp);
        } else downPathSum = dp[right - 1][down];
        return dp[right][down] = grid[right - 1][down - 1] + Math.min(rightPathSum, downPathSum);
    }

    private static int minimumPathSumDP(int[][] grid) {
        Integer[][] dp = new Integer[grid.length + 1][grid[0].length + 1];
        int value = minimumPathSumDP(grid, grid.length, grid[0].length, dp);
        System.out.println(Arrays.deepToString(dp));
        return value;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 3},
                {2, 4}};
        int[][] grid2 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        int[][] grid3 = {
                {1, 2, 5},
                {3, 2, 1}};
        int[][] grid4 = {
                {1, 2},
                {5, 6},
                {1, 1}};

        System.out.println(minimumPathSum(grid3));
        System.out.println(minimumPathSumDP(grid1));
        System.out.println(minimumPathSumDP(grid2));
        System.out.println(minimumPathSumDP(grid3));
        System.out.println(minimumPathSumDP(grid4));
    }
}
