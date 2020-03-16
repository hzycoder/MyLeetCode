package cn.zy.leetCode.majorityElement;

/**
 * 169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/
 * create by park.huang 2020/03/13
 **/
public class Solution {
//    public int majorityElement(int[] nums) {
//        int length = (int) Math.ceil((double) nums.length / 2);
//        Map<Integer, Integer> map = new HashMap<>();
//        Integer times;
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                times = map.get(num);
//                map.put(num, ++times);
//            } else {
//                map.put(num, 1);
//            }
//        }
//        for (Integer key : map.keySet()) {
//            if (map.get(key) >= length) {
//                return key;
//            }
//        }
//        return 0;
//    }

    /**
     * 只循环一次
     * create by park.huang 2020/03/13
     **/
    public int majorityElement(int[] nums) {
        int temp = nums[0];
        int count = 0;
        for (int num : nums) {
            if (num == temp) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                count = 1;
                temp = num;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{3, 3, 2, 2, 3}));
    }

//    /**
//     *  通过排序找到中位数
//     * copy from kernel_coder
//    **/
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }


}