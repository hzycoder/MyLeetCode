package cn.zy.leetCode.maxValue;

/**
 * SOLVED
 * 面试题47. 礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * create by park.huang 2020/03/25
 **/
public class Solution {

    /**
     * dp 自底向上
     * 状态转移方程： grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
     * create by park.huang 2020/03/25
     **/
    public int maxValue(int[][] grid) {
        if (grid.length < 1) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        }));
    }
}