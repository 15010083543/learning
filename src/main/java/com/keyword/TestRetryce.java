package com.keyword;

/**
 * @author LiuPeng
 * @description 测试关键字 Retry
 * 其实retry就是一个标记，标记程序跳出循环的时候从哪里开始执行，功能类似于goto。retry一般都是跟随者for循环出现，
 * 第一个retry的下面一行就是for循环，而且第二个retry的前面一般是 continue或是 break。
 * @date 2018/6/20
 */
public class TestRetryce {

    private volatile int a = 0;

    public static void main(String[] args) {
        int i = 0;
        retry:  //①
        while (true) {
            i++;
            System.out.println("i=" + i);
            System.out.println("-------+++++--------");
            int j = 0;
           //retry:   //②
            for (; ; ) {
                j++;
                System.out.println("j=" + j);
                if (j == 2) {
                    break retry;
                }
            }
        }
    }

}
