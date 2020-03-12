package cn.zy.Shift2Link;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode main = null;
        ListNode last = null;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int c = a + b;
            ListNode tempNode = new ListNode(c % 10 + temp);
            if (main == null) {
                main = tempNode;
            } else {
                last.next = tempNode;
            }
            last = tempNode;
            temp = c >= 10 ? 1 : 0;
            if (temp == 1 && l1.next == null && l2.next == null) {
                l1.next = new ListNode(0);
                l2.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return main;
    }


//    /**
//     * 此方法无法通过大于int.maxValue的测试用例
//     * @param l1
//     * @param l2
//     * @return
//     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        StringBuffer sb = new StringBuffer();
//        while (l1 != null) {
//            sb.append(l1.val);
//            l1 = l1.next;
//        }
//        int a = Integer.parseInt(sb.reverse().toString());
//        sb = new StringBuffer();
//        while (l2 != null) {
//            sb.append(l2.val);
//            l2 = l2.next;
//        }
//        int b = Integer.parseInt(sb.reverse().toString());
//        int result = a + b;
//        sb = new StringBuffer(String.valueOf(result));
//        char[] chars = sb.toString().toCharArray();
//        ListNode link = null;
//        ListNode child = null;
//        for (int i = 0; i < chars.length; i++) {
//            link = new ListNode(chars[i]-48);
//            link.next = child;
//            child = link;
//        }
//        return link;
//    }
}