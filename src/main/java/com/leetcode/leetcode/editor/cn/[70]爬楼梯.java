package com.leetcode.leetcode.editor.cn;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1236 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution70 {
    public int climbStairs(int n) {
        // 递归
        if (n ==1 || n == 2) {
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static int sum(int n){
        if (n ==1 || n ==2) {
            return n;
        }
        int tmp = 1 ,next = 2;
        for (int i = 2; i < n; i++) {
            // 第三个值
            int sum = tmp + next;
            tmp = next;
            next = sum;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(lou(5));
    }

    public static int lou(int n) {
        // 循环
        if (n ==1 || n ==2) return n;
        int tmp = 1;
        int next = 2;
        for (int i = 2; i < n; i++) {
            // 第二个值替换
            int t = next;
            // 第三个值
            next = tmp + next;
            tmp = t;
        }
        return next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
