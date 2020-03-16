package cn.zy.leetCode.climbStairs;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * create by park.huang 2020/03/16
**/
public class Solution {
//    /**
//     * recursion
//     * create by park.huang 2020/03/14
//     **/
//    public int climbStairs(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 1);
//    }

//    Map<Integer, Integer> memoryMap = new HashMap<>();
//    /**
//     * memory search
//     * create by park.huang 2020/03/14
//     **/
//    public int climbStairs(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        if (memoryMap.containsKey(n)) {
//            return memoryMap.get(n);
//        }
//        int n1 = climbStairs(n - 1);
//        int n2 = climbStairs(n - 2);
//        return n1 + n2;
//    }


        Map<Integer, Integer> memoryMap = new HashMap<>();
    /**
     * dp
     * create by park.huang 2020/03/14
     **/
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        memoryMap.put(1, 1);
        memoryMap.put(2, 2);
        for (int i = 3; i <= n; i++) {
            memoryMap.put(i, memoryMap.get(i - 1) + memoryMap.get(i - 2));
        }
        return memoryMap.get(n);
    }
//
//
//    public int climbStairs(int n) {
//        return 0;
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(4));
    }

}