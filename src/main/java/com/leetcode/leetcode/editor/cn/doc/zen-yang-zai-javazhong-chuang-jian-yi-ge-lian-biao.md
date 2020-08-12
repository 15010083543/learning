**ListNode类仅仅是链表的节点的抽象类，如何用该类完成一个链表？**
1. 先实例化（new）两个ListNode类，分别记为pre和cur
2. 令pre=cur **（注意：在java中，此时的pre和cur是指向相同内存位置的指针，因此修改cur指向的实例对象会同步修改pre指向的实例对象，因此不能直接修改cur指向的实例对象的属性，需要为下一节点创建一个新的实例对象）** 
3. 随后new一个新的实例对象，并将cur.next指向这个新的实例对象
4. 随后让cur指针指向cur.next **（注意：这一步骤并未修改原来的pre和cur指针指向的实例对象，而是修改了cur指针，使其指向一个新的地址，即原本的cur.next的地址）**
5. 重复步骤3和4，直到完成链表的创建为止 （cur.next = new ListNode(); cur = cur.next;）
6. **由于pre指针指向的位置一直未发生变化**，因此，在完成链表的创建后，pre指针即指向链表的开始节点，此时除该链表的第一个节点pre和最后一个节点cur外，其余所有节点（pre.next、pre.next.next等节点）均为一个匿名的ListNode类的实例对象

综上所述，如何用ListNode节点类完成一个实际的链表？首先确定开始节点，随后牢记不能修改这个节点，只能修改对应的指针，接下来不停地new新的节点并同时修改cur指针来循环为该链表创建一个个的新的节点（不能修改已经new好的节点！），直到链表创建完成。
<br>
```
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
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode();
        ListNode pre = new ListNode();
        pre = cur;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                cur = cur.next;
                l1 = l1.next;
            }
            else {
                cur.next = new ListNode(l2.val);
                cur = cur.next;
                l2 = l2.next;
            }
        }
        
        if (l1 == null) {
            while (l2 != null) {
                cur.next = new ListNode(l2.val);
                cur = cur.next;
                l2 = l2.next;
            }
        }
        else {
            while (l1 != null) {
                cur.next = new ListNode(l1.val);
                cur = cur.next;
                l1 = l1.next;
            }
        }
        return pre.next;
    }
}
```
