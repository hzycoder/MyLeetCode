package cn.zy.leetCode.massage;

/**
 * SOLVED
 * 面试题 17.16. 按摩师
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 * create by park.huang 2020/03/25
 **/
public class Solution {
    /**
     * dp
     * 自底向上
     * @see cn.zy.leetCode.rob.Solution 198. 打家劫舍
     * create by park.huang 2020/03/25
     **/
    public int massage(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int best = dp[0];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            best = Math.max(best, dp[i]);
        }
        return best;
    }

    public static void main(String[] args){
        System.out.println(new Solution().massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }
}