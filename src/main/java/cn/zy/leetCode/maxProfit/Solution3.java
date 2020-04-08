package cn.zy.leetCode.maxProfit;

/**
 * SOLVED
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * create by park.huang@zkteco.com 2020-04-01 10:09
 **/
public class Solution3 {

    /**
     * 简单动态规划
     * 记录两个变量
     * 1. min，i之前的最小的值
     * 2. max=prices[i]-min 当前最大值
     *
     * create by park.huang 2020/04/01
     **/
    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
