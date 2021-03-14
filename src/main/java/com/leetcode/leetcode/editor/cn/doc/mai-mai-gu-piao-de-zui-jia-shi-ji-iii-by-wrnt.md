#### 方法一：动态规划

**思路与算法**

由于我们最多可以完成两笔交易，因此在任意一天结束之后，我们会处于以下五个状态中的一种：

- 未进行过任何操作；

- 只进行过一次买操作；

- 进行了一次买操作和一次卖操作，即完成了一笔交易；

- 在完成了一笔交易的前提下，进行了第二次买操作；

- 完成了全部两笔交易。

由于第一个状态的利润显然为 *0*，因此我们可以不用将其记录。对于剩下的四个状态，我们分别将它们的**最大利润**记为 !
[\textit{buy}_1 ](./p__textit{buy}_1_.png) ，![\textit{sell}_1 ](./p__textit{sell}_1_.png) ，![\textit{buy}_2 ](./p__textit{buy}_2_.png)  以及 ![\textit{sell}_2 ](./p__textit{sell}_2_.png) 。

如果我们知道了第 *i-1* 天结束后的这四个状态，那么如何通过状态转移方程得到第 *i* 天结束后的这四个状态呢？

对于 ![\textit{buy}_1 ](./p__textit{buy}_1_.png)  而言，在第 *i* 天我们可以不进行任何操作，保持不变，也可以在未进行任何操作的前提下以 
![\textit{prices}\[i\] ](./p__textit{prices}_i__.png)  的价格买入股票，那么 ![\textit{buy}_1 ](./p__textit{buy}_1_.png)  的状态转移方程即为：

![\textit{buy}_1=\max\{\textit{buy}_1',-\textit{prices}\[i\]\} ](./p___textit{buy}_1_=_max_{_textit{buy}_1',_-textit{prices}_i__}__.png) 

这里我们用 ![\textit{buy}_1' ](./p__textit{buy}_1'_.png)  表示第 *i-1* 天的状态，以便于和第 *i* 天的状态 ![\textit{buy}_1 ](./p__textit{buy}_1_.png)  进行区分。

对于 ![\textit{sell}_1 ](./p__textit{sell}_1_.png)  而言，在第 *i* 天我们可以不进行任何操作，保持不变，也可以在只进行过一次买操作的前提下以 ![\textit{prices}\[i\] ](./p__textit{prices}_i__.png)  的价格卖出股票，那么 ![\textit{sell}_1 ](./p__textit{sell}_1_.png)  的状态转移方程即为：

![\textit{sell}_1=\max\{\textit{sell}_1',\textit{buy}_1'+\textit{prices}\[i\]\} ](./p___textit{sell}_1_=_max_{_textit{sell}_1',_textit{buy}_1'_+_textit{prices}_i__}__.png) 

同理我们可以得到 ![\textit{buy}_2 ](./p__textit{buy}_2_.png)  和 ![\textit{sell}_2 ](./p__textit{sell}_2_.png)  对应的状态转移方程：

![\begin{aligned}&\textit{buy}_2=\max\{\textit{buy}_2',\textit{sell}_1'-\textit{prices}\[i\]\}\\&\textit{sell}_2=\max\{\textit{sell}_2',\textit{buy}_2'+\textit{prices}\[i\]\}\end{aligned} ](./p___begin{aligned}_&_textit{buy}_2_=_max_{_textit{buy}_2',_textit{sell}_1'_-_textit{prices}_i__}__&_textit{sell}_2_=_max_{_textit{sell}_2',_textit{buy}_2'_+_textit{prices}_i__}_end{aligned}__.png) 

在考虑边界条件时，我们需要理解下面的这个事实：

> 无论题目中是否允许「在同一天买入并且卖出」这一操作，最终的答案都不会受到影响，这是因为这一操作带来的收益为零。

因此，在状态转移时，我们可以直接写成：

![\begin{cases}\textit{buy}_1=\max\{\textit{buy}_1,-\textit{prices}\[i\]\}\\\textit{sell}_1=\max\{\textit{sell}_1,\textit{buy}_1+\textit{prices}\[i\]\}\\\textit{buy}_2=\max\{\textit{buy}_2,\textit{sell}_1-\textit{prices}\[i\]\}\\\textit{sell}_2=\max\{\textit{sell}_2,\textit{buy}_2+\textit{prices}\[i\]\}\end{cases} ](./p___begin{cases}_textit{buy}_1_=_max_{_textit{buy}_1,_-textit{prices}_i__}__textit{sell}_1_=_max_{_textit{sell}_1,_textit{buy}_1_+_textit{prices}_i__}__textit{buy}_2_=_max_{_textit{buy}_2,_textit{sell}_1_-_textit{prices}_i__}__textit{sell}_2_=_max_{_textit{sell}_2,_textit{buy}_2_+_textit{prices}_i__}_end{cases}__.png) 

例如在计算 ![\textit{sell}_1 ](./p__textit{sell}_1_.png)  时，我们直接使用 ![\textit{buy}_1 ](./p__textit{buy}_1_.png)  而不是 ![\textit{buy}_1' ](./p__textit{buy}_1'_.png)  进行转移。![\textit{buy}_1 ](./p__textit{buy}_1_.png)  比 ![\textit{buy}_1' ](./p__textit{buy}_1'_.png)  多考虑的是在第 *i* 天买入股票的情况，而转移到 ![\textit{sell}_1 ](./p__textit{sell}_1_.png)  时，考虑的是在第 *i* 天卖出股票的情况，这样在同一天买入并且卖出收益为零，不会对答案产生影响。同理对于 ![\textit{buy}_2 ](./p__textit{buy}_2_.png)  以及 ![\textit{sell}_2 ](./p__textit{sell}_2_.png) ，我们同样可以直接根据第 *i* 天计算出的值来进行状态转移。

那么对于边界条件，我们考虑第 *i=0* 天时的四个状态：![\textit{buy}_1 ](./p__textit{buy}_1_.png)  即为以 ![\textit{prices}\[0\] ](./p__textit{prices}_0__.png)  的价格买入股票，因此 ![\textit{buy}_1=-\textit{prices}\[0\] ](./p__textit{buy}_1=-textit{prices}_0__.png) ；![\textit{sell}_1 ](./p__textit{sell}_1_.png)  即为在同一天买入并且卖出，因此 ![\textit{sell}_1=0 ](./p__textit{sell}_1=0_.png) ；![\textit{buy}_2 ](./p__textit{buy}_2_.png)  即为在同一天买入并且卖出后再以 ![\textit{prices}\[0\] ](./p__textit{prices}_0__.png)  的价格买入股票，因此 ![\textit{buy}_2=-\textit{prices}\[0\] ](./p__textit{buy}_2=-textit{prices}_0__.png) ；同理可得 ![\textit{sell}_2=0 ](./p__textit{sell}_2=0_.png) 。我们将这四个状态作为边界条件，从 *i=1* 开始进行动态规划，即可得到答案。

在动态规划结束后，由于我们可以进行不超过两笔交易，因此最终的答案在 *0*，![\textit{sell}_1 ](./p__textit{sell}_1_.png) ，![\textit{sell}_2 ](./p__textit{sell}_2_.png)  中，且为三者中的最大值。然而我们可以发现，由于在边界条件中 ![\textit{sell}_1 ](./p__textit{sell}_1_.png)  和 ![\textit{sell}_2 ](./p__textit{sell}_2_.png)  的值已经为 *0*，并且在状态转移的过程中我们维护的是最大值，因此 ![\textit{sell}_1 ](./p__textit{sell}_1_.png)  和 ![\textit{sell}_2 ](./p__textit{sell}_2_.png)  最终一定大于等于 *0*。同时，如果最优的情况对应的是恰好一笔交易，那么它也会因为我们在转移时允许在同一天买入并且卖出这一宽松的条件，从 ![\textit{sell}_1 ](./p__textit{sell}_1_.png)  转移至 ![\textit{sell}_2 ](./p__textit{sell}_2_.png) ，因此最终的答案即为 ![\textit{sell}_2 ](./p__textit{sell}_2_.png) 。

**代码**

```C++ [sol1-C++]
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = max(buy1, -prices[i]);
            sell1 = max(sell1, buy1 + prices[i]);
            buy2 = max(buy2, sell1 - prices[i]);
            sell2 = max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
};
```

```Java [sol1-Java]
class Solution {
 对于任意一天考虑四个变量:
        fstBuy: 在该天第一次买入股票可获得的最大收益 
        fstSell: 在该天第一次卖出股票可获得的最大收益
        secBuy: 在该天第二次买入股票可获得的最大收益
        secSell: 在该天第二次卖出股票可获得的最大收益
        分别对四个变量进行相应的更新, 最后secSell就是最大
        收益值(secSell >= fstSell)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
```

```Python [sol1-Python3]
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        buy1 = buy2 = -prices[0]
        sell1 = sell2 = 0
        for i in range(1, n):
            buy1 = max(buy1, -prices[i])
            sell1 = max(sell1, buy1 + prices[i])
            buy2 = max(buy2, sell1 - prices[i])
            sell2 = max(sell2, buy2 + prices[i])
        return sell2
```

```go [sol1-Golang]
func maxProfit(prices []int) int {
    buy1, sell1 := -prices[0], 0
    buy2, sell2 := -prices[0], 0
    for i := 1; i < len(prices); i++ {
        buy1 = max(buy1, -prices[i])
        sell1 = max(sell1, buy1+prices[i])
        buy2 = max(buy2, sell1-prices[i])
        sell2 = max(sell2, buy2+prices[i])
    }
    return sell2
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
```

```C [sol1-C]
#define max(a, b) ((a) < (b) ? (b) : (a))

int maxProfit(int* prices, int pricesSize) {
    int buy1 = -prices[0], sell1 = 0;
    int buy2 = -prices[0], sell2 = 0;
    for (int i = 1; i < pricesSize; ++i) {
        buy1 = max(buy1, -prices[i]);
        sell1 = max(sell1, buy1 + prices[i]);
        buy2 = max(buy2, sell1 - prices[i]);
        sell2 = max(sell2, buy2 + prices[i]);
    }
    return sell2;
}
```

```JavaScript [sol1-JavaScript]
var maxProfit = function(prices) {
    const n = prices.length;
    let buy1 = -prices[0], buy2 = -prices[0];
    let sell1 = 0, sell2 = 0;
    for (let i = 1; i < n; i++) {
        buy1 = Math.max(buy1, -prices[i]);
        sell1 = Math.max(sell1, buy1 + prices[i]);
        buy2 = Math.max(buy2, sell1 - prices[i]);
        sell2 = Math.max(sell2, buy2 + prices[i]);
    }
    return sell2;
};
```

**复杂度分析**

- 时间复杂度：*O(n)*，其中 *n* 是数组 ![\textit{prices} ](./p__textit{prices}_.png)  的长度。

- 空间复杂度：*O(1)*。