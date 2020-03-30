package cn.zy.leetCode.rob;

/**
 * SOLVED
 * 198. 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 * create by park.huang 2020/03/23
 **/
public class Solution {

//    /**
//     * dp  自底向上
//     * create by park.huang 2020/03/23
//     **/
//    public int rob(int[] nums) {
//        int[] dp = new int[nums.length];
//        if (nums.length < 1) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        if (nums.length == 2) {
//            return Math.max(nums[0], nums[1]);
//        }
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//        int tempMax = 0;
//
//        for (int i = 2; i < nums.length; i++) {
//            for (int j = 0; j < i - 1; j++) {
//                tempMax = Math.max(tempMax, dp[j]);
//            }
//            dp[i] = nums[i] + tempMax;
//        }
//        int max = 0;
//        for (int i = 1; i < dp.length; i++) {
//            max = Math.max(dp[i], dp[i - 1]);
//        }
//        return max;
//    }

    /**
     * optimized dp
     * create by park.huang 2020/03/24
     **/
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
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
        System.out.println(new Solution().rob(new int[]{2, 7, 9, 3, 1}));
    }
}