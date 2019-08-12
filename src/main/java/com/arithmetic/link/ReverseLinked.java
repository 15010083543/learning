package com.arithmetic.link;

/**
 * @author LiuPeng
 * @description 单向链表反转
 * @date 2019/8/12
 */
public class ReverseLinked {

    public static void main(String[] args) {
        BaseLinked baseLinked1 = new BaseLinked(1);
        BaseLinked baseLinked2 = new BaseLinked(2);
        BaseLinked baseLinked3 = new BaseLinked(3);
        BaseLinked baseLinked4 = new BaseLinked(4);

        baseLinked1.next = baseLinked2;
        baseLinked2.next = baseLinked3;
        baseLinked3.next = baseLinked4;

        //BaseLinked re1 = ReverseLinked.recursionReverseLinked(baseLinked1);
        //System.out.println(re1);
        BaseLinked re2 = ReverseLinked.circleReverseLinked(baseLinked1);
        System.out.println(re2);
    }

    // 循环方法 理解简单
    public static BaseLinked circleReverseLinked(BaseLinked head) {
        if(null == head) return null;
        // 定义边界节点
        BaseLinked prev = null;
        BaseLinked cur = head;
        while (null != cur){
            BaseLinked tmp = cur.next;
            // 切断之前的指向
            cur.next = prev;
            // 把当前的值付给前一个节点
            prev = cur;
            // 把临时节点赋值给当前
            cur = tmp;
        }
        return prev;
       /* if (null == head) return null; 理解比较复杂
        BaseLinked pre = head;
        BaseLinked cur = head.next;
        BaseLinked tmp ;
        while (null != cur){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = null;
        return pre;*/
    }

    // 递归方法
    public static BaseLinked recursionReverseLinked(BaseLinked head) {
        if (null == head || null == head.next) return head;
        BaseLinked next = recursionReverseLinked(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
