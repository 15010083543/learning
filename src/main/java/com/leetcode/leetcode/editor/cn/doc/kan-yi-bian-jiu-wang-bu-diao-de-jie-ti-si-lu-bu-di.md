**分析**
维护两个变量，只需要一次遍历：
最小元素`minVal`代表着遍历过的元素中最小值；
最大利润变量`maxPro`代表截止目前所能获取的最大利润；

**思路**
1. 特判：过滤掉空数组情况；
2. 初始化：
    - `minVal`初始值设置为`prices[0]`，表示初始值为第一天的股票价格；
    - `maxPro`初始值设置为`0`，第一天只能买或者不买，不能卖，因此初始值为0；
3. 遍历，**对数组中的每一个元素e做如下处理**：
    - 更新`minVal`
    - 更新`maxPro = min{maxPro , e-minVal}`


**代码**
```java []
class Solution {
    public int maxProfit(int[] prices) {      
        //特判
        if(prices == null || prices.length == 0) return 0; 
        //初始化 
        int minVal = prices[0];  
        int maxPro = 0;
        //遍历
        int len = prices.length;
        for(int i = 0; i < len; i++){     
            minVal = Math.min(minVal, prices[i]);
            maxPro = Math.max(maxPro, prices[i] - minVal);
        }
        return maxPro;
    }
}
```


关于`maxPro`初始值设置为`0`的补充：
    - 由于题目中说明了最多只允许完成一次交易，也就是说不存在利润为负数的情况，也就是大不了不交易嘛~


 [微信图片_20200920111253.jpg](https://pic.leetcode-cn.com/1600589268-UMUWfH-%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200920111253.jpg)


