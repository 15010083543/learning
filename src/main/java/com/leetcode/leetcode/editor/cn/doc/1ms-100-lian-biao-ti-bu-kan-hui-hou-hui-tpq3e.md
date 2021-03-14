### 解题思路
* 首先说明能用链表做还是要用链表来做，这是正规的解法
* 但是为了笔试快速通过，可以遍历链表节点来放入集合中，根据题意一系列操作后，再重新把节点串起来
* 链表转集合后，你会发现题目就很简单了
* 用本题举例，挨个遍历链表元素，放入集合中，m到n集合反转
* 最后顺序遍历集合，来把链表串起来，返回链表

### 代码

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
      if(head == null) {
          return head;
      }
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val); //所有元素放入集合
            cur = cur.next;
        } 
        int i = m - 1; //注意索引要减一，因为集合从0开始
        int j = n - 1;
        while (i < j) { //交换m到n的元素
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
        ListNode dumy = new ListNode(0);
        ListNode res = dumy;
        for (int k = 0; k < list.size(); k++) {
            dumy.next = new ListNode(list.get(k)); //重新串节点
            dumy = dumy.next;
        }
        return res.next;
    }
}
```