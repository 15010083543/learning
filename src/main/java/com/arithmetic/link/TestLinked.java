package com.arithmetic.link;

import com.arithmetic.LinkedList;

/**
 * @author LiuPeng
 * @description 链表算法学习
 * @date 2019/12/21
 */
public class TestLinked {

    public static void main(String[] args) {
        LinkedNode linkedNode1 = new LinkedNode(1);
        LinkedNode linkedNode2 = new LinkedNode(2);
        LinkedNode linkedNode3 = new LinkedNode(3);
        LinkedNode linkedNode4 = new LinkedNode(6);
        LinkedNode linkedNode5 = new LinkedNode(7);
        linkedNode1.next = linkedNode2;
        linkedNode2.next = linkedNode3;
        linkedNode3.next = linkedNode4;
        linkedNode4.next = linkedNode5;

        LinkedNode linkedNode21 = new LinkedNode(5);
        linkedNode21.next = linkedNode4;

        //getIntersectionNode(linkedNode1, linkedNode21);
        System.out.println(recursionReverseLinked(linkedNode1));

    }

    /*
     *@description 单向链表反转
     *@param linkedNode
     *@return com.arithmetic.link.LinkedNode
     * 头插法，每循环一次给头节点插入一个节点
     */
    public static LinkedNode reverseLinked(LinkedNode linkedNode){
        LinkedNode lastNode = null;
        if (null != linkedNode) {
            LinkedNode cur = linkedNode;
            while (null != cur) {
                // 定义一个临时节点，防止引用被修改
                LinkedNode tmp = cur.getNext();
                // 把之前节点作为当前节点的下一个节点
                cur.setNext(lastNode);
                // 把当前节点赋值给最终节点
                lastNode = cur;
                // 把临时节点赋值给当前节点
                cur = tmp;
            }
        }
        return lastNode;
    }

    // 利用递归的思想做反转链表
    // 递归是有边界
    public static LinkedNode recursionReverseLinked(LinkedNode linkedNode){
        if (null == linkedNode || null == linkedNode.getNext()) return linkedNode;
        LinkedNode cur = recursionReverseLinked(linkedNode.getNext());
        linkedNode.next.next = linkedNode;
        linkedNode.next = null;
        return cur;
    }
    /**
     * @author LiuPeng
     * @description 找到两个单链表相交的起始节点。
     * 实现思想
     *  把A和B两个链表的头结点赋值个pA，pB，依次循环，当循环完本链表之后进行交换，直到找到相交节点或是结束
     * @date 2019/12/21
     */
    public static LinkedNode getIntersectionNode(LinkedNode headA, LinkedNode headB){
        if (headA == null || headB == null) { return null; }
        LinkedNode a = headA;
        LinkedNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.getNext();
            b = b == null ? headA : b.getNext();
        }
        return a;
    }

}
