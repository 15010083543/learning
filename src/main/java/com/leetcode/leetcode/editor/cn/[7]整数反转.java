package com.leetcode.leetcode.editor.cn;
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
//




//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学 
// 👍 2098 👎 0

/*
溢出条件有两个，一个是大于整数最大值MAX_VALUE，另一个是小于整数最小值MIN_VALUE，设当前计算结果为ans，下一位为pop。
从ans * 10 + pop > MAX_VALUE这个溢出条件来看
当出现 ans > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出
当出现 ans == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7是2^31 - 1的个位数
从ans * 10 + pop < MIN_VALUE这个溢出条件来看
当出现 ans < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
当出现 ans == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位数

 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse2(int x) {
        if (0 == x) {
            return 0;
        }
        String num = x +"";
        char[] bytes = num.toCharArray();
        int length = bytes.length;
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            char swap = bytes[length-i - 1];
            if ('-' == swap) {
                flag = true;
                continue;
            }
            stringBuilder.append(swap);
        }
        String lastStr = "";
        if (flag) {
            lastStr = "-" + stringBuilder.toString();
        } else {
            lastStr = stringBuilder.toString();
        }
        int finalNum = 0;
        try {
            finalNum = Integer.parseInt(lastStr);
        } catch (NumberFormatException e) {
            // 数据溢出用try来处理
            return 0;
        }
        return finalNum;
    }


    // 完美的答案
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }


    // 不校验溢出的方法
    public static int reverse3(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10; // 每次取末位数
            ans = ans * 10 + pop;  // 末位数反转为首位数
            x /= 10; // 每次往后退1位
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(reverse(200));
        System.out.println(reverse3(-20));
        System.out.println(reverse3(201));
        System.out.println(reverse3(2));
    }
}


//leetcode submit region end(Prohibit modification and deletion)
