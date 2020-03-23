package cn.zy.leetCode.numDecodings;

/**
 * UNSOLVED SKIP
 * 91. 解码方法
 * https://leetcode-cn.com/problems/decode-ways/
 * create by park.huang 2020/03/23
 **/
public class Solution {
    public int numDecodings(String s) {
        if (s.length() < 1) {
            return 0;
        }
        if (s.replaceAll("0", "").length() == 0) {
            return 0;
        }
        int result = 1;
        if (s.startsWith("0")) {
            return  0;
        }
        if (s.contains("0")) {
            result = 0;
        }
        byte[] bytes = s.getBytes();
        byte first = bytes[0];
        for (int i = 1; i < bytes.length; i++) {
            byte curr = bytes[i];
            if (first == 48) {
            } else if (first < 50) {
                result++;
            } else if (first == 50 && curr < 55) {
                result++;
            }
            first = curr;
//            System.out.print(new String(new byte[]{(byte) (bytes[i] + 16)}));
//            System.out.print(" ");
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(new Solution().numDecodings("012"));;
    }
}