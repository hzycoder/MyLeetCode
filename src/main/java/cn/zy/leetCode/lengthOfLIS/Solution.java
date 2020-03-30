package cn.zy.leetCode.lengthOfLIS;

/**
 * 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * create by park.huang 2020/03/14
 **/
public class Solution {
    //    public int lengthOfLIS(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int flag;
//        int length = 1;
//        int maxLength = 1;
//        int temp;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                flag = nums[i];
//                temp =
//                for (int k = i; k < nums.length; k++) {
//                    int curr = nums[k];
//                    if (curr > flag) {
//                        length++;
//                        flag = nums[k];
//                    }
//                }
//                if (length > maxLength) {
//                    maxLength = length;
//                }
//                length = 1;
//                temp++;
//            }
//        }
//        return Math.max(length, maxLength);
//    }
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = 1;
        int maxLen = 1;
        int first;
        for (int i = 0; i < nums.length; i++) {//第一重循环 控制 first
            for (int j = i + 1; j < nums.length; j++) { //第二重循环 控制第一个和first比较的数
                first = nums[i];
                for (int k = j; k < nums.length; k++) { //第三重循环 真正循环比较
                    if (first < nums[k]) {
                        len++;
                        first = nums[k];
                    }
                }
                if (len > maxLen) {
                    maxLen = len;
                }
                len = 1;
            }
        }
        return Math.max(len, maxLen);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12}));
    }
}