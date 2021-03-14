### 解题思路
此处撰写解题思路
**思路**：
自下而上的解决，所以需要迭代，而不是使用递归

**状态转移方程**：
 n=1,n=2, 1,2
 f(n) = f(n-1)+f(n-2)  n>2

 问题就变得很简单了。

**其他解决方式**：
 （1）记忆化搜索
 （2）可以使用多线程ForkJoin （这个方法，需要考虑线程切换需要付出的代价）
### 代码

```java
class Solution {
   public int climbStairs(int n) {

        if (n<0) return  0;
        if (n<2)return n;

        int[] dp  = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
```