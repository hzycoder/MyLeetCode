package cn.zy.leetCode.uniquePathsWithObstacles;

/**
 * SOLVED
 * 63. 不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * create by park.huang 2020/03/23
 **/
public class Solution {
    /**
     * dp 自底向上
     * create by park.huang 2020/03/23
     **/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m > 100 || m < 1) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (n > 100 || n < 1) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (j - 1 >= 0) {
                    if (obstacleGrid[i][j - 1] != 1) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
                if (i - 1 >= 0) {
                    if (obstacleGrid[i - 1][j] != 1) {
                        dp[i][j] += dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePathsWithObstacles(
                new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                }));

    }
}