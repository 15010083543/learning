# 方法：移除重复项
算法
数组完成排序后，我们可以从头遍历，当当前nums[i]===nums[i+1]时，我们可以移除数组中从i开始的一项，即nums.splice(i,1),此时由于数组少一项，我们需要将i置为i-1。最后返回nums.length即可
```javascript
var removeDuplicates = function(nums) {
  for(let i = 0;i<nums.length;i++){
   if(nums[i]===nums[i+1]){
     nums.splice(i,1)
     i-=1  
   }   
  }
  return nums.length
};
```
# 复杂度分析
- 时间复杂度：O(n),假设数组长度是n，那么i最多走n步。
- 空间复杂度：O(1)。