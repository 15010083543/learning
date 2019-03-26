package com.leetcode;

/**
 * @author LiuPeng
 * @description
 * @date 2019/3/18
 */
/**
 * Definition for singly-linked list.
 *
 * }
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    public static void main(String[] args) {

    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode node = dummyHead;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    ListNode dummyHead1 = new ListNode(l1.val);
                    node.next = dummyHead1;
                    l1 = l1.next;
                } else {
                    ListNode dummyHead2 = new ListNode(l2.val);
                    node.next = dummyHead2;
                    l2 = l2.next;
                }
            }
            while (l1 != null) {
                ListNode dummyHead3 = new ListNode(l1.val);
                node.next = dummyHead3;
                l1 = l1.next;
            }

            while (l2 != null) {
                ListNode dummyHead4 = new ListNode(l2.val);
                node.next = dummyHead4;
                l2 = l2.next;
            }
            return node;
        }
    }


}
