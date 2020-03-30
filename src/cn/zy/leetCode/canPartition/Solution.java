package cn.zy.leetCode.canPartition;

/**
 * UNSOLVED
 * 416. 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * create by park.huang 2020/03/30
 **/
public class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        if (total % 2 != 0) {
            return false;
        }
        total = total / 2;

        int[][] dp = new int[nums.length + 1][nums.length + 1];
        dp[1] = nums;
        for (int i = 2; i <nums.length; i++) {
            for (int j = 0; j < nums.length - i + 1; j++) {
                dp[i][j] = dp[i - 1][j] + nums[j + i - 1];
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(new Solution().canPartition(new int[]{1, 5, 11, 5}));
    }
}