package com.leetcode.leetcode.editor.cn;
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1178 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = x + "";
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i < charArray.length / 2 + 1) {
                if (charArray[i] != charArray[charArray.length - 1 - i]) {
                    return false;
                }
            }
        }
        return true;
    }

  /* public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
