### 解题思路
- 1: 经典老题，很容易理解到 爬上n阶台阶的方法数等于爬上n-1 的方法数加上n-2 的方法数之和
- 2: 那么及很容易想到使用递归的方式，如下
```
class Solution {
    public int climbStairs(int n) {
       if(n == 1 || n == 2){
           return n;
       }
       return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
```
- 3: 递归涉及到了很多的重复计算，提交会导致超时，那么可以换一种方式
- 4: 既然f(n) = f(n-1) + f(n-2), 那么 f(n-1) = f(n-2) + f(n-3) 以此类推
- 5: 我们可以定义 f(0) = 1 , f(1) = 1; f(2) = f(0) + f(1);  
- 6: 后续看注释

### 代码

```java
class Solution {
    public int climbStairs(int n) {
        //  a = f(0) = 1; b = f(1) = 1
        int a = 1, b = 1;
        for (int i = 2; i <= n; i++) {
            // f(2) = a + b;
            int sum = a + b;
            // a = f(1)
            a = b;
            // b = f(2)   及以此将a b 的值 变为f(n-2) 与 f(n-1)
            b = sum;
        }
        return b;
    }
}
```