package cn.zy.leetCode.maxProfit;

/**
 * SOLVED
 * 309. 最佳买卖股票时机含冷冻期
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * create by park.huang 2020/03/24
 **/
public class Solution {
    /**
     * key: 状态的定义和转移
     * reference： https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/dong-tai-gui-hua-by-liweiwei1419-5/
     * dp 自底向上
     * create by park.huang 2020/03/24
     **/
    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        if (prices.length == 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0]; //持股
        dp[0][1] = 0; //不持股
        dp[0][2] = 0; //冷冻期
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = dp[i - 1][1];
        }
        return Math.max(Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]), dp[prices.length - 1][2]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 4}));
    }
}