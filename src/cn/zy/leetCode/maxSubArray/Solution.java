package cn.zy.leetCode.maxSubArray;

/**
 * SOLVED
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 面试题 16.17. 连续数列
 * https://leetcode-cn.com/problems/contiguous-sequence-lcci/
 * create by park.huang 2020/03/17
 **/
public class Solution {


//    /**
//     * create by park.huang 2020/03/18
//     **/
//    public int maxSubArray(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int max = nums[0];
//        int best = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            best = best + nums[i];
//            best = Math.max(best, nums[i]);
//            if (max < best) {
//                max = best;
//            }
//        }
//        return max;
//    }

    /**
     * dp 自底向上
     * create by park.huang 2020/03/25
     **/
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            best = Math.max(dp[i], best);
        }
        return best;
    }


//    /**
//     * 超出规定时间
//     * o(n)+o(logn)???
//     * create by park.huang 2020/03/17
//     **/
//    public int maxSubArray(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int total = nums[0];
//        for (int first = 0; first < nums.length; first++) {
//            int size = nums.length - first;
//            for (int j = 1; j <= size; j++) {
//                int count = getCount(nums, first, j + first);
//                total = Math.max(count, total);
//            }
//        }
//        return total;
//    }
//
//    public int getCount(int[] nums, int first, int length) {
//        int total = 0;
//        for (int i = first; i < length; i++) {
//            total += nums[i];
//        }
//        return total;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}