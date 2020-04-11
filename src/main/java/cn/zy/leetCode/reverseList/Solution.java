package cn.zy.leetCode.reverseList;

/**
 * UNSOLVED
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 206. 反转链表
 * create by park.huang 2020/04/11
 **/
class Solution {


    public ListNode reverseList(ListNode head) {
        ListNode temp = head.next;
        return null;
    }

    public static void main(String[] args) {
        ListNode three = new ListNode(3);
        ListNode eight = new ListNode(8);
        ListNode five = new ListNode(5);
        ListNode one = new ListNode(1);
        three.next = eight;
        eight.next = five;
        five.next = one;
        one.next = null;
        new Solution().reverseList(three);
        System.out.println("ok");
    }
}