package cn.zy.leetCode.waysToChange;

/**
 * 面试题 08.11. 硬币
 * https://leetcode-cn.com/problems/coin-lcci/
 * create by park.huang 2020/03/28
 *
 * @see cn.zy.leetCode.waysToStep.Solution
 **/
public class Solution {

//    /**
//     * UNSOLVED
//     * dp 自底向上
//     * @see cn.zy.leetCode.waysToStep.Solution
//     * create by park.huang 2020/03/28
//     **/
//    public int waysToChange(int n) {
//        int m = 1000000007;
//        if (n <= 0) {
//            return 0;
//        }
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        int temp;
//        for (int i = 1; i <= n; i++) {
//            temp = dp[i - 1];
//            if (i - 5 > 0) {
//                temp += (dp[i - 5]);
//                temp -= i / 5;
//            }
//            if (i - 10 > 0) {
//                temp += (dp[i - 10] );
//                temp -= i / 10;
//            }
//            if (i - 25 > 0) {
//                temp += (dp[i - 25] );
//                temp -= i / 25;
//            }
//
//            if (i == 5 || i == 10 || i == 25) {
//                temp++;
//            }
//            dp[i] = temp % m;
//        }
//        return dp[n];
//    }

    /**
     * dp 二维
     * reference: https://leetcode-cn.com/problems/coin-lcci/solution/dpzhu-shi-ming-que-by-yangzl_zz/
     **/
    public int waysToChange(int n) {
        if (n < 5)
            return 1;
        if (n == 5)
            return 2;
        int[] coins = {1, 5, 10, 25};
        int[][] dp = new int[4][n + 1];
        // 当数量为0，1时，有1种表示法
        for (int i = 0; i < 4; ++i) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        // 当只有一种硬币时，只有1种表示法
        for (int i = 0; i <= n; ++i)
            dp[0][i] = 1;
        /*
         * 状态：dp[i][j]表示[0...i]种硬币能组合为j的所有不同种数
         * 状态转移：取 或 不取 当前硬币coins[i]
         */
        for (int i = 1; i < 4; ++i) {
            for (int j = 2; j <= n; ++j) {
                if (j >= coins[i])
                    dp[i][j] = (dp[i][j - coins[i]] + dp[i - 1][j]) % 1000000007;
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[3][n];
    }
    public static void main(String[] args) {
        System.out.println(new Solution().waysToChange(25));
//        for (int i = 10; i < 30; i++) {
//            System.out.println("i " + i + ": " + new Solution().waysToChange(i));
//        }
    }
}