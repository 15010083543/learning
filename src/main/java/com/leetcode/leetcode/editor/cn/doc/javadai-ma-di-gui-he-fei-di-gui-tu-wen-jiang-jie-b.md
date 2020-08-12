
### 因为链表是升序的，我们只需要遍历每个链表的头，比较一下哪个小就把哪个链表的头拿出来放到新的链表中，一直这样循环，直到有一个链表为空，然后我们再把另一个不为空的链表挂到新的链表中。

### 我们就以3→4→7→9和2→5→6两个链表来画个图看一下是怎么合并的。
 [image.png](https://pic.leetcode-cn.com/8056ae02cbcd1b170ef27d7553d0281accfd31f2673353dd6fc472f80301c4f1-image.png)
 [image.png](https://pic.leetcode-cn.com/ceb23158d4d4921dc754fe2e149bbbcfca0a3a13dd63ecc18a2890e4f4254383-image.png)
 [image.png](https://pic.leetcode-cn.com/332476e453a011a1ee83860ae07f6b1795adf361ab04061fefa28f57a2982b1d-image.png)

### 看明白了上面的图，代码就很容易写了，我们来看一下非递归的代码
```
    public ListNode mergeTwoLists(ListNode linked1, ListNode linked2) {
        //下面4行是空判断
        if (linked1 == null)
            return linked2;
        if (linked2 == null)
            return linked1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (linked1 != null && linked2 != null) {
            //比较一下，哪个小就把哪个放到新的链表中
            if (linked1.val <= linked2.val) {
                curr.next = linked1;
                linked1 = linked1.next;
            } else {
                curr.next = linked2;
                linked2 = linked2.next;
            }
            curr = curr.next;
        }
        //然后把那个不为空的链表挂到新的链表中
        curr.next = linked1 == null ? linked2 : linked1;
        return dummy.next;
    }
```

### 我们还可以把它改为递归的形式，看下递归的代码

```
    public ListNode mergeTwoLists(ListNode linked1, ListNode linked2) {
        if (linked1 == null)
            return linked2;
        if (linked2 == null)
            return linked1;
        if (linked1.val < linked2.val) {
            linked1.next = mergeTwoLists(linked1.next, linked2);
            return linked1;
        } else {
            linked2.next = mergeTwoLists(linked1, linked2.next);
            return linked2;
        }
    }
```
### 递归代码我们还可以再改一下
```
    public ListNode mergeTwoLists(ListNode linked1, ListNode linked2) {
        //只要有一个为空，就返回另一个
        if (linked1 == null || linked2 == null)
            return linked2 == null ? linked1 : linked2;
        //把小的赋值给first
        ListNode first = (linked2.val < linked1.val) ? linked2 : linked1;
        first.next = mergeTwoLists(first.next, first == linked1 ? linked2 : linked1);
        return first;
    }
```
 [a1b7c667f08bace157ec8fd3e8cb53a.jpg](https://pic.leetcode-cn.com/78ddaae72768ba19be3cc3a20198295d46920a8631d868750e39f013b43e3748-a1b7c667f08bace157ec8fd3e8cb53a.jpg)

### 如果想查看更多答案，可关注我微信公众号“**[数据结构和算法](https://img-blog.csdnimg.cn/20190515124616751.jpg)**”，也可以扫描上方二维码关注
