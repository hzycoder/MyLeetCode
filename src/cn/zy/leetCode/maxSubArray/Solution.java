package cn.zy.leetCode.maxSubArray;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO UNSOLVED
 * 53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * create by park.huang 2020/03/17
 **/
public class Solution {


    /**
     * create by park.huang 2020/03/18
     **/
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int sum = 0;
        int big = nums[0];
        Map<Integer, Integer> tempMap;
        for (int start = 0; start < nums.length; start++) {
            for (int length = 1; length <= nums.length - start; length++) {
                sum = 0;
                if (map.containsKey(start) && map.get(start).containsKey(length-1)) {
                    int b = map.get(start).get(length - 1);
                    int num = nums[start + length - 1];
                    tempMap = new HashMap<>();
                    tempMap.put(length, b + num);
                    big = Math.max(big,  b + num);
                    map.put(start, tempMap);
                    break;
                }
                sum = getCount(start, length, nums);
                tempMap = new HashMap<>();
                tempMap.put(length, sum);
                big = Math.max(big, sum);
                map.put(start, tempMap);
            }
        }
        return Math.max(big, sum);
    }

    public int getCount(int start, int length, int[] nums) {
        int count = 0;
        for (int i = start; i < length+start; i++) {
            count += nums[i];
        }
        return count;
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