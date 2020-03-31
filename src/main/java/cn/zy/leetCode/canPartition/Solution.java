package cn.zy.leetCode.canPartition;

/**
 * SOLVED
 * 416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * create by park.huang 2020/03/30
 **/
public class Solution {
    /**
     * 01背包 动态规划
     * reference: https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
     * create by park.huang 2020/03/31
     **/
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) {
            return false;
        }
        total = total / 2;

        boolean[][] dp = new boolean[nums.length][total + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (i == 0) {
                    dp[i][j] = nums[i] == j;
                } else {
                    if (j - nums[i] >= 0) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        return dp[nums.length - 1][total];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 5, 11, 15}));
    }
}