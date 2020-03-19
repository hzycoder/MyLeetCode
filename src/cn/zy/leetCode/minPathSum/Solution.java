package cn.zy.leetCode.minPathSum;

/**
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * create by park.huang 2020/03/19
 **/
public class Solution {
    /**
     * dp 自底向上
     * create by park.huang 2020/03/19
     **/
    public int minPathSum(int[][] grid) {
        int sum = 0;
        if (grid.length == 0) {
            return sum;
        }
        int[][] dp = grid;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (row == 0 && col == 0) {
                    continue;
                }
                if (row == 0) {  //在第一行的时候
                    dp[row][col] = grid[row][col - 1] + grid[row][col];
                } else if (col == 0) { //在最左边列的时候
                    dp[row][col] = grid[row - 1][col] + grid[row][col];
                } else {
                    dp[row][col] = Math.min(grid[row - 1][col], grid[row][col - 1]) + grid[row][col];
                }
            }
        }
        return dp[grid.length - 1][grid[grid.length - 1].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new Solution().minPathSum(grid));
    }
}