package cn.zy.leetCode.cuttingRope;

/**
 * SOLVED
 * 面试题14- I. 剪绳子
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * @see cn.zy.leetCode.integerBreak.Solution  整数拆分
 * create by park.huang 2020/03/25
 **/
public class Solution {

//    /**
//     * 数学公式思路
//     * according to the mathematics
//     * @see cn.zy.leetCode.integerBreak.Solution  整数拆分
//     * create by park.huang 2020/03/26
//     **/
//    public int cuttingRope(int n) {
//        if (n < 4) {
//            return n - 1;
//        }
//        int i = n % 3;
//        if (i == 1) {
//            return (int) (Math.pow(3, (n / 3) - 1) * 4);
//        } else if (i == 2) {
//            return (int) (Math.pow(3, n / 3) * 2);
//        } else {
//            return (int) (Math.pow(3, (n / 3)));
//        }
//    }


    /**
     * DP
     * create by park.huang 2020/03/26
     **/
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n+1];
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }



    public static void main(String[] args) {
        System.out.println(new Solution().cuttingRope(10));
    }
}