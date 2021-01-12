### 解题思路

动态规划 - 笔记
1. 用dp[i][1] 和 dp[i][1] 来表示第i天卖出 和 买入 的最大收益，
2. 设第1天卖出 和 买入 的收益
3. 遍历第i天的卖出 和 买入的收益
4. 返回最后一天的卖出收益值

```
例子：
          7   |   1   |   5   |   3   |   6   |   4
第一天.  0  -7 |       |       |       |       |
第二天.        | 0  -1 |       |       |       |
第三天.        |       | 4  -1 |       |       |            
第四天.        |       |       | 4  -1 |       | 
第五天.        |       |       |       | 5  -1 | 
第六天.        |       |       |       |       | 5  -1

因为前一天可能卖出也可能买入，所以当天的卖出买入值要 和 前一天卖出买入值中选择最大的收益;
第i天选择卖出的收益将是前一天的卖出 和 前一天的买入值+今天买入的钱 中选择最大值；
    设i=2(第三天) 第二天卖出的话我的收益是0，今天卖出的话我的收益就是 第二天买入的收益值加今天的5，
    收益就是-4。所以还是选择前一天的卖出值，也就是今天不动。

第i天选择买入的收益将是前一天的买入 和 今天买入花的钱的最大值；
    设i=1(第二天) 第一天买入我花7元，第二天买入我只花一元。
```


方法 : maxProfit2 - 优化空间
方法:maxProfit中可以得出 只需要知道第i-1天买入 和 卖出的收益，就可以求出求第i天卖出的收益；
所以只保留i-1天的买入 和 卖出的变量

### 代码
```java
import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;

        int[][] dp = new int[len][2];
        // 设第1天卖出 和 买入 的收益
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            // 第i天的卖出 和 买入
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[len - 1][0];
    }

    // maxProfit2 - 优化空间
    public int maxProfit2(int[] prices) {
        if ( prices.length <= 1 ) return 0;
        int buy = 0;
        int sell = -prices[0];
        for( int i = 1; i < prices.length; ++i ) {
            buy = Math.max( buy, sell + prices[i] );
            sell = Math.max( sell, -prices[i] );
        }
        return Math.max( buy, sell );
    }


    // 
    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        int res = (new Solution()).maxProfit2(prices);
        System.out.println(res);
    }
}
```
