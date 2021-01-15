### 解题思路
此处撰写解题思路
归并排序的标准模板 这里有个细节问题:在写递归终止条件的时候 不能随意的改变递归深度
随意改变递归深度会导致返回顺序出现问题
主要理解：21题的递归解法.
### 代码

```java
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
    public ListNode mergeKLists(ListNode[] lists) {
        //在这里使用分治法 进行归并排序 底层原理为mergeTwoLists
        if(lists.length==0) return null;
        return mergeSort(lists,0,lists.length-1);
        
        
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        else if(l2==null) return l1;
        if(l1.val<l2.val) {
        l1.next=mergeTwoLists(l1.next, l2);
        return l1;//分别将两个已经合并好的链表的最小节点依次返还给表头
        //根据递归的顺序 第一个进行递归地节点是最后一个被返回的 也是最小的
        //所以此时整个链表是有序的
    }
        else{
            l2.next=mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    ListNode mergeSort(ListNode[] lists,int lo,int hi){
        int mid=(hi+lo)/2;
        if(hi==lo) return lists[lo];//在这里的递归终止条件必须写成if(lo==hi) 因为随意改变递归深度可能会导致返回的顺序出现问题
        ListNode l1=mergeSort(lists, lo, mid);
        ListNode l2=mergeSort(lists, mid+1, hi);
        return mergeTwoLists(l1, l2);
    }
}
```