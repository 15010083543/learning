package com.leetcode.leetcode.editor.cn;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1142 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution21 {

    // 指针的交换问题
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode listNode = new ListNode(-1);
        ListNode tmp = listNode;
        while (null != l1 && null != l2) {
            if (l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = null != l1 ? l1 : l2;
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l3;
        l3.next = l5;
        l2.next = l4;
        l4.next = l6;
        ListNode listNode = mergeTwoLists(l1, l2);

       /* ListNode tmp = l1;
        tmp.next = new ListNode(2);
        l1.next = tmp.next;
        l1.next = new ListNode(3);
        tmp = tmp.next;
        System.out.println(l1);
        System.out.println(tmp);*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

