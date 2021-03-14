### 解题思路
首先我想到的是双重for循环来解答这个问题，通过二次循环比较nums[i]+nums[j]的值来查询，但是这样做的话，考虑最坏的情况，时间复杂度(nums.length-1)*(nums.length)。于是我在考虑有没有什么可以一次解决的，
第二个方法还是看评论区老哥的，然后去深刻的理解了一下。map可以存储k-v键值对，然后通过containsKey方法来判断键是否存在。这里在put过程中之所以把target-nums[i]得到的补数作为键存储是因为键是唯一的，而数组下标本就是唯一，所以做value存储并不影响，但target-nums[i]如果作为值来存储来就可能出现多个相同的补值，不符合题目要求了。我们在计算时，假设传入的nums为[3,4,2]，target是5，那么通过循环，首先3这个键是不存在的，那么存入3的补值2，value为0，在接下来的过程中，就给了我们明确的查找对象，那就是2。这样做可以给每次传入的值确认与之另一个符合要求的数值。所以第二次循环传入的是<1,1>，第三次循环传入值为2containsKey方法返回true，进入到if内部，我们返回indexs[0]的下标，对应的就是第一次传入的3的补值2的下标0，第二次则就是第三次循环i的下标2，得出结果。
其实这里的话还可以做一个小优化，这里这样做的话就算找到了对应的2个元素，依旧会继续执行完循环，所以在找到答案过后，我们可以中断这个循环。跳出去直接返回indexs,可以有效的提高效率。具体怎么做就看各位靓仔们的操作了哈哈。

### 代码

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] indexs = new int[2];

        // for(int i=0; i<nums.length; i++){
        //     for(int j =nums.length-1; j>i; j--){
        //         if(nums[i]+nums[j] == target){
        //             indexs[0] = i;
        //             indexs[1] = j;
        //         }
        //     }
        // }

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                indexs[0] = map.get(nums[i]);
                indexs[1] = i;
            }
            map.put(target-nums[i],i);
        }

        return indexs;
    }
}
```