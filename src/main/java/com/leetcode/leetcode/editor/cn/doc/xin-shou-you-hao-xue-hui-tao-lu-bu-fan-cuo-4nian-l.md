五月份的开头，友好题目。

给出我做链表题目的一些套路。

# 哑节点

创建 哑节点 作为 结果链表 的开头，返回结果是这个节点的下一个位置。目的是：在未遍历之前，我们不知道构建的结果中，开头元素到底是 l1 还是 l2, 为了让代码整齐，创建哑节点。

# 使用 move 游标

哑节点标记了 结果链表 的开头，因此是不能移动的。为了把两个链表 merge 的结果放到结果链表的最后，就需要使用一个 move 游标指向 结果链表 的最后一个元素。初始时，move 指向 哑节点，之后随着结果链表的增加而不停地向后移动，始终保持其指向 结果链表 的最后一个元素。

# while 遍历两个元素

涉及到两个元素的遍历题，使用 `while l1 and/or l2` 的方式。即两个元素都没有遍历完或者至少有一个没遍历完，具体使用 `and` 还是 `or` 要根据场景进行选择。

这类常见的题目有：
1. 合并两个链表
2. 两数相加/两个链表表示的数相加

# 没用完的元素仍需拼接

当 `while` 循环结束之后，l1 和 l2 至少遍历完了一个，另一个链表可能没有用完，因此需要拼接到 结果链表 的结尾。
合并链表 或者 两数相加 都要记得这个问题。

至于本题并不难，只需要判断两个链表头部元素的大小，把小的那个链表节点放到 结果链表 的结尾即可。

Python 代码如下，其他语言可以根据我的详细注释修改：

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 创建哑节点作为 结果链表 的开头
        dummy = ListNode(0)
        # 有个游标，标识 结果链表 的结尾
        move = dummy
        # l1 和 l2 都未遍历结束
        while l1 and l2:
            # 如果 l1 的数值比较小
            if l1.val <= l2.val:
                # 把 l1 头部节点拼接到 结果链表 的结尾
                move.next = l1
                # l1 指向下一个节点
                l1 = l1.next
            else:
                # 把 l2 头部节点拼接到 结果链表 的结尾
                move.next = l2
                # l2 指向下一个节点
                l2 = l2.next
            # 移动 结果链表 的结尾指针
            move = move.next
        # l1 或者 l2 尚未使用完，拼接到 结果链表 的最后
        move.next = l1 if l1 else l2
        # 返回哑节点的下一个位置
        return dummy.next
```

学会了上面的一些经验之后，就能避免很多错误，比如我4年来提交过很多次这个题目，从来没有犯过错。

 [image.png](https://pic.leetcode-cn.com/c3e10a5020316b22bb55ed25298d0d61536fb1e25dcde6a232d4fe7687983859-image.png)

### 欢迎关注[负雪明烛的刷题博客](https://blog.csdn.net/fuxuemingzhu)，刷题800多，每道都记录了写法！目前访问量已经接近100万次！

### 送大家刷题模板和套路总结：[【LeetCode】代码模板，刷题必会](https://blog.csdn.net/fuxuemingzhu/article/details/101900729)

### 大家一起来监督力扣刷题，每日一题监督打卡网站上线啦 [https://ojeveryday.com/](https://ojeveryday.com/)
