package cn.zy.leetCode.minimumTotal;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * SOLVED
 * 120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 * create by park.huang 2020/03/16
**/
public class Solution {

    /**
     * 这不是DP
     * 更不是自顶向下
     * 只是从上往下的搜寻方向
     * 自顶向下是递归的思想，和方向无关系；和迭代的具体方向和子问题有关。
     *
     * 从上往下是贪心算法，得到的解只能保证局部最优，并不能保证全局最优
     * create by park.huang 2020/03/17
    **/
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int result;
//        if (triangle.size() == 1) {
//            return triangle.get(0).get(0);
//        }
//        result = triangle.get(0).get(0);
//        int offset = 0;
//        int temp;
//        for (int i = 1; i < triangle.size(); i++) {
//            List<Integer> numsRow = triangle.get(i);
//            Integer down = numsRow.get(offset);
//            if (offset == numsRow.size()) {
//                result += down;
//            } else if (down > numsRow.get(offset + 1)) {
//                result += numsRow.get(offset + 1);
//                offset++;
//            } else {
//                result += down;
//            }
//        }
//        return result;
//    }


//    /**
//     * 递归方法
//     * create by park.huang 2020/03/17
//     **/
//    public int minimumTotal(List<List<Integer>> triangle) {
//
//        return triangle
//    }
//
//    int total = 0;
//    int offset = 0;
//    public int recursion(List<List<Integer>> triangle) {
//        if (triangle.size() == 1) {
//            total += triangle.get(0).get(0);
//            return total;
//        }
//        List<Integer> integers = triangle.get(0);
//
//
//
//        triangle.remove(0);
//        recursion(triangle);
//        return total;
//    }

    /**
     * 递归，自顶向下 【超时】
     * https://leetcode-cn.com/problems/triangle/solution/di-gui-ji-yi-hua-sou-suo-zai-dao-dp-by-crsm/
     * copy from Elon 2020/03/19
    **/
//    int row;
//    public int minimumTotal(List<List<Integer>> triangle) {
//        row=triangle.size();
//        return helper(0,0, triangle);
//    }
//    private int helper(int level, int c, List<List<Integer>> triangle){
//         System.out.println("helper: level="+ level+ " c=" + c);
//        if (level==row-1){
//            return triangle.get(level).get(c);
//        }
//        int left = helper(level+1, c, triangle);
//        int right = helper(level+1, c+1, triangle);
//        return Math.min(left, right) + triangle.get(level).get(c);
//    }


    /**
     * DP
     * 自底向上
     * reference: https://leetcode-cn.com/problems/triangle/solution/man-hua-jue-dui-neng-kan-de-dong-de-dong-tai-gui-h/
     * create by park.huang 2020/03/19
    **/
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int dp[][] = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                    continue;
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }
        int[] ints = dp[triangle.size() - 1];
        int min = ints[0];
        for (int i = 1; i < ints.length; i++) {
            min = Math.min(min, ints[i]);
        }
        return min;
    }


    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Lists.newArrayList(-1));
        triangle.add(Lists.newArrayList(2,3));
        triangle.add(Lists.newArrayList(1,-1,-3));
        System.out.println(new Solution().minimumTotal(triangle));
    }
}