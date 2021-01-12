解题思路：
思路比较简单，定义两个指针i和j,进行循环匹配，相信各位大佬都能看懂的。


java 代码

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int i=0,j=0;
        while((i<haystack.length())&&(j<needle.length())){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else {
                i=i-j+1;
                j=0;
            }
        }
        if(j>=needle.length()) return i-needle.length();
        else return -1;
    }
}
```