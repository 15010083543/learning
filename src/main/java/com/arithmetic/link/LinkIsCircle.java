package com.arithmetic.link;

import java.util.HashSet;

/**
 * @author LiuPeng
 * @description 链表是否有回环
 * @date 2019/8/13
 */
public class LinkIsCircle {

    public static void main(String[] args) {
        BaseLinked baseLinked1 = new BaseLinked(1);
        BaseLinked baseLinked2 = new BaseLinked(2);
        BaseLinked baseLinked3 = new BaseLinked(3);
        BaseLinked baseLinked4 = new BaseLinked(4);

        baseLinked1.next = baseLinked2;
        baseLinked2.next = baseLinked3;
        baseLinked3.next = baseLinked4;
        baseLinked4.next = baseLinked2;

        boolean flag = findBeginLoop(baseLinked1);
        System.out.println(flag);
    }

    /*1.快慢指针
    参考资料点这里。 

    用两个指针指向链表头，每次循环，快指针往前两步，慢指针往前一步；在循环过程中，如果快指针等于慢指针（相遇），则表示链表有环；否则不存在环。代码如下：*/
    public static boolean findBeginLoop2(BaseLinked head) {
        if (null == head || null == head.next)
            return false;
        BaseLinked cur = head;
        BaseLinked pre = head;
        while (null != pre.next && null != pre.next.next) {
            cur = cur.next;
            pre = pre.next.next;
            if (cur == pre)
                return true;
        }
        return false;
    }

   /* 如何计算环的长度？

    在相遇点，两个指针继续一个走一步，一个走两步，当再次相遇时，走一步的指针所走过的节点数记为环的长度。

    如何计算环离起点的长度？*/
   public static boolean findBeginLoop(BaseLinked head) {
       if (null == head || null == head.next)
           return false;
       BaseLinked cur = head;
       BaseLinked pre = head;
       boolean falg = false;
       int count = 0;
       while (null != pre.next && null != pre.next.next) {
           cur = cur.next;
           pre = pre.next.next;
           if (cur == pre)
               falg = true;
           if (falg) {
               count++;
               if (cur == pre) {
                   System.out.println(count);
                   return true;
               }
           }
       }
       return false;
   }



}
