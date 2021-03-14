两个指针分别从两个链表头开始移动,若移动到当前链表的结尾处,则指向另一链表的头节点再次开始遍历.
这样若两链表有相交节点,两个指针会同时到达这个节点(因为走过了相同长度的路程)
用另外两个变量来标识是否是第一次访问这个链表,用于处理两个不相交链表的情况.
```
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null) return null;
        ListNode p1=headA;
        ListNode p2=headB;
        int mark1=0;
        int mark2=0;
        while (p1!=p2){
            p1=p1.next;
            p2=p2.next;
            if (p1==null) {
                if (mark1==1) return null;
                p1=headB;
                mark1=1;
            }
            if (p2==null) {
                if (mark2==1) return null;
                p2=headA;
                mark2=1;
            }
        }
        return p1;
    }
}
```
