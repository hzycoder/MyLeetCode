package cn.zy.leetCode.numSquares;

/**
 * SOLVED
 * 279. 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 * create by park.huang 2020/03/20
 **/
public class Solution {
    /**
     * dp 自底向上
     * create by park.huang 2020/03/20
     **/
    public int numSquares(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 4) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            double sqrt = Math.sqrt(i);
            int sqrtInt = (int) sqrt;
            if (sqrt - sqrtInt == 0) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j < i; j++) {
                if (dp[i] == 0) {
                    dp[i] = dp[j] + dp[i - j];
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}