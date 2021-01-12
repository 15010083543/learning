### 速度
 [image.png](https://pic.leetcode-cn.com/1605756272-jwfdUM-image.png)
 [image.png](https://pic.leetcode-cn.com/1605761342-CsmrXk-image.png)


### 解题思路
target 在 nums 外先判断。
其他中间切半，跑 while，
target 比中间大，start 等于中间，反之则相反。
target 等于中间数的时候，返回中间数位置。

要注意的是，剩下两个数的时候(也就是 end - start = 1)，中间数一定是 start，因为把 .5 舍去了。
target 有可能介于 nums[start] 和 nums[end] 之间，或是等于 nums[end]，这两种情况都是返回 start + 1。

### 代码

```python3 []
class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        if target > nums[-1]:
            return len(nums)
        elif target < nums[0]:
            return 0

        start = 0
        end = len(nums) - 1
        while True:
            middle = int((start + end) / 2)
            m_num = nums[middle]
            if target == m_num:
                return middle
            elif end - start == 1:
                return start + 1
            elif target > m_num:
                start = middle
            elif target < m_num:
                end = middle
```

```javascript []
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    let last = nums.length - 1
    if(target > nums[last]) return last + 1
    else if(target < nums[0]) return 0

    let start = 0
    let end = last
    let middle = 0
    let m_num = 0
    while(true){
        middle = Math.floor((start + end) / 2)
        m_num = nums[middle]
        if(target == m_num) return middle
        else if(end - start == 1) return start + 1
        else if(target > m_num) start = middle
        else if(target < m_num) end = middle
    }
};
```