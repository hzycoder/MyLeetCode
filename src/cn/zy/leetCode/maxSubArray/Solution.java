package cn.zy.leetCode.maxSubArray;

/**
 * TODO UNSOLVED
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * create by park.huang 2020/03/17
 **/
public class Solution {

    /**
     * 超出规定时间
     * o(n)+o(logn)???
     * create by park.huang 2020/03/17
     **/
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int total = nums[0];
        for (int first = 0; first < nums.length; first++) {
            int size = nums.length - first;
            for (int j = 1; j <= size; j++) {
                int count = getCount(nums, first, j + first);
                total = Math.max(count, total);
            }
        }
        return total;
    }

    public int getCount(int[] nums, int first, int length) {
        int total = 0;
        for (int i = first; i < length; i++) {
            total += nums[i];
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2,1}));
    }
}