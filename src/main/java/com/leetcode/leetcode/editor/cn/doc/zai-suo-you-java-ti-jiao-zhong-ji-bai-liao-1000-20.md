 [QQ截图20200806190329.png](https://pic.leetcode-cn.com/594932f3ec030cf7264a53a55d6fb0c35fc33e8ac1377413837318408de1f57b-QQ%E6%88%AA%E5%9B%BE20200806190329.png)

双指针，一个pre用来记录上一个不重复的元素位置，另一个cur用来记录当前位置。
每次判断当前位置元素是否与pre元素值相等，相等则跳过，更新cur；不等则把pre指向当前元素cur，更新pre为cur，再更新cur。
代码见下：
```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;
        ListNode pre = head;//指向第一个不重复的节点
        ListNode cur = head.next;//当前节点
        while(cur!=null){
            if(cur.val!=pre.val){//找到了一个新的不重复节点，则把pre指向cur，更新pre
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;//更新cur
        }
        pre.next = null;//切断pre与剩余重复元素的联系
        return head;
    }
}
```


