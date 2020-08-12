### 解题思路
1、首先遍历数组，遍历数组的时候进行比较
- 如果target > 当前的值，则继续向后遍历
- 如果target == 当前的值，则直接返回结果
- 如果target < 当前的值，说明找到了插入的位置，直接返回结果

2、到这儿就结束了？没有的！
- 别忘了考虑target > nums中每个数字的情况，这时候需要返回nums的长度。

### 代码

```java
//欢迎关注微信公众号：视学算法（非视觉算法）
class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(target > nums[i]) continue;
            if(target == nums[i]) return i;
            if(target < nums[i]) return i;
        }
        return nums.length;
    }
}
```