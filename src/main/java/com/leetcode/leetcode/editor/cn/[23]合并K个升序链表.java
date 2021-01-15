package com.leetcode.leetcode.editor.cn;
//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1080 👎 0


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
class Solution23 {
    // 分而治之的思想
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) {
            return null;
        }
        return mergeList(lists, 0, lists.length-1);
    }

    private static ListNode mergeList(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        int mid = l + (r + l) >> 2;
        ListNode first = mergeList(lists, l, mid);
        ListNode two = mergeList(lists, mid+1, r);
        return mergeTwoList(first, two);
    }

    private static ListNode mergeTwoList(ListNode leftList, ListNode rightList) {
        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }
        ListNode newNode = new ListNode(-1);
        ListNode tmp = newNode;
        while (leftList != null && rightList != null) {
            if (leftList.val < rightList.val) {
                tmp.next = leftList;
                leftList = leftList.next;
            } else {
                tmp.next = rightList;
                rightList = rightList.next;
            }
            tmp = tmp.next;
        }
        tmp.next = rightList == null ? leftList : rightList;
        return newNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(10);

        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);

        l1.next = l3;
        l3.next = l5;

        l2.next = l4;
        l4.next = l6;

        l7.next = l8;
        l8.next = l9;
        ListNode[] listNodes = new ListNode[]{l1, l2, l7};
        ListNode listNode = mergeKLists(listNodes);
        System.out.println(listNode);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
