package cn.zy.leetCode.waysToStep;

/**
 * SOLVED
 * 面试题 08.01. 三步问题
 * https://leetcode-cn.com/problems/three-steps-problem-lcci/
 * create by park.huang 2020/03/28
 **/
public class Solution {

    /**
     * dp 自底向上
     * create by park.huang 2020/03/28
     **/
    public int waysToStep(int n) {
        if (n < 4) {
            return (int) (Math.pow(2, n) / 2);
        }
        int m = 1000000007;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i - 1] % m+ dp[i - 2]% m)% m + dp[i - 3]% m)%m;
        }
        return dp[n] % m;
    }

    public static void main(String[] args){
        System.out.println(new Solution().waysToStep(61));
    }
}