package cn.zy.leetCode.uniquePaths;


/**
 * SOLVED
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 * create by park.huang 2020/03/23
 **/
public class Solution {
    /**
     * DP 自底向上
     * create by park.huang 2020/03/23
     **/
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1 || n > 100) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(7, 3));
    }
}