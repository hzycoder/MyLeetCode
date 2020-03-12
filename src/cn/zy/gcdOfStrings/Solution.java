package cn.zy.gcdOfStrings;

/**
 * 1071. 字符串的最大公因子
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 * create by park.huang@zkteco.com 2020-03-12 14:27
 **/
public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    /**
     * wouldn't judge which bigger between a and b.
     * because operate % and params order of this method.
     * when a smaller than b , a and b will change position next time/
     */
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
