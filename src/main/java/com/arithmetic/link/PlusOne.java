package com.arithmetic.link;

/**
 * @author LiuPeng
 * @description 链表加一
 * @date 2019/8/13
 */
public class PlusOne {
    public static void main(String[] args) {
        BaseLinked baseLinked1 = new BaseLinked(9);
        BaseLinked baseLinked2 = new BaseLinked(9);
        BaseLinked baseLinked3 = new BaseLinked(9);
        BaseLinked baseLinked4 = new BaseLinked(9);

        baseLinked1.next = baseLinked2;
        baseLinked2.next = baseLinked3;
        //baseLinked3.next = baseLinked4;

        //BaseLinked re1 = ReverseLinked.recursionReverseLinked(baseLinked1);
        //System.out.println(re1);
        BaseLinked re2 = recursionPlusOne(baseLinked1);
        System.out.println(re2);
    }

    /* 解法

     链表与数组区别在于链表只能从前往后去遍历, 但加一行为是从表尾去操作, 往前进位非常不方便, 因此最直接的解法是将链表反转, 之前的表尾转换为表头, 从表头开始进行加一操作, 最后再将链表反转。
     链表和二叉树都是特别适合递归的数据结构, 既然我们想操作表尾, 直接通过递归获取进位, 最后再考虑进位是否添加到表头。
     非递归模式, 采用栈这种数据结构。
     首先找到链表最后一个不为9的元素, 如果没有, 说明链表元素都为9, 在表头添加新节点(值为1), 后续所有节点值都赋值为1;如果找到, 当前节点值加1, 后续所有节点值同样赋值为0。

     Java代码*/
    public static BaseLinked recursionPlusOne(BaseLinked head) {
        if (head == null) {
            return null;
        }
        int carry = getCarrier(head);
        if (carry == 1) { // 首位是否加一
            BaseLinked root = new BaseLinked(carry);
            root.next = head;
            return root;
        }
        return head;
    }

    public static int getCarrier(BaseLinked node) {
        if (node == null) {
            return 1; // 加一
        }
        int carry = getCarrier(node.next);
        int sum = node.num + carry;
        node.num = sum % 10;
        return sum / 10;
    }

}
