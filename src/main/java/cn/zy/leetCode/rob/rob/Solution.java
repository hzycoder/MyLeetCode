package cn.zy.leetCode.rob.rob;

/**
 * SOLVED
 * 213. 打家劫舍 II
 * https://leetcode-cn.com/problems/house-robber-ii/
 * create by park.huang 2020/03/24
 **/
public class Solution {

    /**
     * DP 自底向上
     * create by park.huang 2020/03/24
     **/
    public int rob(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] withoutFirstArr = new int[nums.length-1];
        int[] withoutLastArr = new int[nums.length - 1];
        System.arraycopy(nums, 1, withoutFirstArr, 0, nums.length - 1);
        System.arraycopy(nums, 0, withoutLastArr, 0, nums.length - 1);
        int withoutFirst = handle(withoutFirstArr);
        int withoutLast = handle(withoutLastArr);
        return Math.max(withoutFirst, withoutLast);
    }

    public int handle(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(dp[i], dp[i - 1]);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1, 1, 1, 2}));
    }
}