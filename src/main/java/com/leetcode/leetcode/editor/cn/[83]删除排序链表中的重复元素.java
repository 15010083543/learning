package com.leetcode.leetcode.editor.cn;
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 373 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (null != head){
            ListNode pre = head;
            int value = pre.val;
            while (null != pre.next){
                ListNode node = pre.next;
                if (value == node.val) {
                    pre.next = node.next;
                } else {
                    pre = node;
                }
                value = node.val;
            }
       }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        //ListNode listNode = deleteDuplicates(l1);

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
