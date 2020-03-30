package cn.zy.leetCode.maxProfit;

/**
 * 面试题63. 股票的最大利润
 * 买卖股票一次
 * https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * create by park.huang@zkteco.com 2020-03-25 16:22
 **/
public class Solution2 {

    /**
     * easy
     * create by park.huang 2020/03/25
     **/
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }

    public static void main(String[] args){
        System.out.println(new Solution2().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
