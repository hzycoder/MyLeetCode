package cn.zy.leetCode.integerBreak;

/**
 * SOLVED
 * 343. 整数拆分
 * https://leetcode-cn.com/problems/integer-break/
 * create by park.huang 2020/03/20
 **/
public class Solution {
    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 2];
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i],
                        Math.max(dp[j] * dp[i - j],     // 计算dp[j] * dp[i-j]
                                Math.max((i - j) * j, dp[j] * (i - j))));   // 计算 (i-j) * j  和  dp[j] * (i-j)
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(13));
    }
}