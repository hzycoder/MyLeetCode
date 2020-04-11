package cn.zy.leetCode.deleteNode;

/**
 * SOLVED
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * 237. 删除链表中的节点
 * create by park.huang 2020/04/10
 **/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 更改指针
     * create by park.huang 2020/04/10
     **/
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args){
        ListNode three = new ListNode(3);
        ListNode eight = new ListNode(8);
        ListNode five = new ListNode(5);
        ListNode one = new ListNode(1);
        three.next = eight;
        eight.next = five;
        five.next = one;
        new Solution().deleteNode(five);
        System.out.println(three.val);
    }
}