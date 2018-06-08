package com.other;

/**
 * @author LiuPeng
 * @description 递归三角数
 * 递归的特征
 * 1.调用自身
 * 2.调用自身的时候是为了解决更小的问题
 * 3.存在某个足够简单的问题的层次，在这一层算法不需要调用自己就可以直接解答并且返回结果
 * @date 2018/6/8
 */
public class Triangle {

    public static void main(String[] args) {
        System.out.println(triangle1(4));
        System.out.println(triangle2(4));
    }

    // 普通循环方法
    public static int triangle1(int n) {
        int i = 1;
        int num = 0;
        while (i <= n) {
            num += i;
            i++;
        }
        return num;
    }

    // 递归方法(加入跟踪连)
    public static int triangle2(int n) {
        System.out.println("Entering: n = " + n);
        if (n == 1) { // 需要一个边界
            System.out.println("Returning 1");
            return 1;
        } else {
            int temp = n + triangle2(n - 1);
            System.out.println("Returning " + temp);
            return temp;
        }
        /*Entering: n = 4
            Entering: n = 3
            Entering: n = 2
            Entering: n = 1
            Returning 1
            Returning 3
            Returning 6
            Returning 10 */


    }

}
