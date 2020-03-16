package cn.zy.leetCode.minimumTotal;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * create by park.huang 2020/03/16
**/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int result;
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        result = triangle.get(0).get(0);
        int offset = 0;
        int temp;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> numsRow = triangle.get(i);
            temp = numsRow.get(offset);
            for (int j = offset + 1; j < numsRow.size(); j++) {
                if (temp > numsRow.get(j)) {
                    temp = numsRow.get(j);
                    offset = j;
                }
            }
            System.out.println(temp);
            result += temp;
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Lists.newArrayList(-1));
        triangle.add(Lists.newArrayList(2,3));
        triangle.add(Lists.newArrayList(1,-1,-3));
        System.out.println(new Solution().minimumTotal(triangle));
    }
}