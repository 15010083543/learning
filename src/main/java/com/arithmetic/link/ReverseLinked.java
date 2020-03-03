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

        //LinkedNode re1 = ReverseLinked.recursiveReverseLinked(linkedNode1);
        //System.out.println(re1);

        LinkedNode re2 = ReverseLinked.recevice(linkedNode1);
        System.out.println(re2);

    }

    // 如何用语言来描述如何实现反转 假设存在链表 1 → 2 → 3 → Ø，我们想要把它改成 Ø ← 1 ← 2 ← 3。
    // 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
    /* 1.核心思路：循环每一个节点然后把该值（包含next值）赋给一个变量，
       2.当循环到当前节点时，把这个节点的值设置为之前定义的变量
       3.把当前节点的值赋给定义的变量
       4.循环结束时返回该变量
     */
       public static LinkedNode recevice(LinkedNode linkedNode){
        LinkedNode pre = null;// 1 2-1 3-2-1
        LinkedNode head = linkedNode;
        while (null != head) {
            LinkedNode tmp = head.next;
            head.next = pre; // 做替换
            pre = head; // 赋新值
            head = tmp;
        }
        return pre;
    }

    // 递归方法
    public static LinkedNode recursiveReverseLinked(LinkedNode head) {
        if (null == head || null == head.next) return head;
        LinkedNode next = recursiveReverseLinked(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

}
