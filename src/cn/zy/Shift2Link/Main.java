package cn.zy.Shift2Link;

/**
 * create by park.huang@zkteco.com 2020-01-20 15:41
 **/
public class Main {
    public static void main(String[] args)
    {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(5);
//        l1.next = new ListNode();
//        l1.next.val = 4;
//        l1.next.next = new ListNode();
//        l1.next.next.val = 3;

        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode();
//        l2.next.val = 6;
//        l2.next.next = new ListNode();
//        l2.next.next.val = 4;
        ListNode listNode = solution.addTwoNumbers(l1, l2);

    }
}
