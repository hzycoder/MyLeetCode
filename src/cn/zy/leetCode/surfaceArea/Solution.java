package cn.zy.leetCode.surfaceArea;

/**
 * SOLVED
 * 892. 三维形体的表面积
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
 * create by park.huang 2020/03/25
 **/
public class Solution {
    /**
     * 总面积-叠加面积
     * create by park.huang 2020/03/25
     **/
    public int surfaceArea(int[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    if (i != 0) {
                        total -= Math.min(grid[i - 1][j], grid[i][j]);
                    }
                    if (j != 0) {
                        total -= Math.min(grid[i][j - 1], grid[i][j]);
                    }
                    if (j != grid[i].length - 1) {
                        total -= Math.min(grid[i][j + 1], grid[i][j]);
                    }
                    if (i != grid.length - 1) {
                        total -= Math.min(grid[i + 1][j], grid[i][j]);
                    }
                    total += (grid[i][j] << 2) + 2;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().surfaceArea(new int[][]{
                {2}
        }));
    }
}