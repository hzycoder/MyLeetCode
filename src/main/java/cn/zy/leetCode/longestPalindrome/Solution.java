package cn.zy.leetCode.longestPalindrome;

/**
 * SOLVED
 * 5. Longest Palindromic Substring
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * create by park.huang 2020/04/01
 **/
class Solution {
    /**
     * create by park.huang 2020/04/01
     **/
    public String longestPalindrome(String s) {
        if (s.length() < 1) {
            return "";
        } else if (s.length() == 1) {
            return s;
        }
        int strLen = s.length();
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            return s;
        }

        int tempFirst = 0, tempLast = 0;
        int first = 0, last = 0;
        int max = 0;
        for (int i = 0; i < strLen; i++) {
            // 剪枝
            if ((strLen - (i + 1)) * 2 + 1 <= max) break;
            for (int num = 1; num <= 2; num++) {
                for (int j = 0; j <= Math.min(strLen - i - num - 1, i); j++) {
                    boolean b = s.charAt(i - j) == s.charAt(i + j + num);
                    if (b) {
                        tempFirst = i - j;
                        tempLast = i + j + num;
                    }
                    if (tempLast - tempFirst > max) {
                        max = tempLast - tempFirst;
                        last = tempLast;
                        first = tempFirst;
                    }
                    if (!b) break;
                }
            }
        }
        return s.substring(first, last + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
    }
}