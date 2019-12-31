package com.arithmetic.link;

/**
 * @author LiuPeng
 * @description 单向链表反转
 * @date 2019/8/12
 */
public class ReverseLinked {

    public static void main(String[] args) {
        LinkedNode linkedNode1 = new LinkedNode(1);
        LinkedNode linkedNode2 = new LinkedNode(2);
        LinkedNode linkedNode3 = new LinkedNode(3);
        LinkedNode linkedNode4 = new LinkedNode(4);

        linkedNode1.next = linkedNode2;
        linkedNode2.next = linkedNode3;
        linkedNode3.next = linkedNode4;

        //LinkedNode re1 = ReverseLinked.recursionReverseLinked(linkedNode1);
        //System.out.println(re1);
        LinkedNode re2 = ReverseLinked.recursionReverseLinked(linkedNode1);
        System.out.println(re2);
    }

    // 递归方法
    public static LinkedNode recursionReverseLinked(LinkedNode head) {
        if (null == head || null == head.next) return head;
        LinkedNode next = recursionReverseLinked(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
