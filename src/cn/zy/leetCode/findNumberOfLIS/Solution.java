package cn.zy.leetCode.findNumberOfLIS;

/**
 * 673. 最长递增子序列的个数
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 * create by park.huang 2020/03/12
 * 未通过
 **/
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int length = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > temp) {
                temp = nums[i];
                length++;
            }
        }
        for (int i = 1; i < nums.length; i++) {

        }
        return length;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 3, 4, 6, 3};
        int[] nums = new int[]{10, 12, 13, 2, 3, 4, 5, 6};

        int numberOfLIS = new Solution().findNumberOfLIS(nums);
        System.out.println(numberOfLIS);
    }
}