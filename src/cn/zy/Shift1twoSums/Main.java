package cn.zy.Shift1twoSums;

import java.util.Arrays;

/**
 * create by park.huang@zkteco.com 2020-01-20 15:28
 **/
public class Main {
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int[] ints = solution.twoSum(nums, 9);
        if (ints != null) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
