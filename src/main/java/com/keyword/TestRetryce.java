package com.keyword;

/**
 * @author LiuPeng
 * @description 测试关键字 Retry
 * @date 2018/6/20
 */
public class TestRetryce {

    private volatile int a = 0;

    public static void main(String[] args) {
        int i = 0;
       // retry:  //①
        while (true) {
            i++;
            System.out.println("i=" + i);
            System.out.println("-------+++++--------");
            int j = 0;
           retry:   //②
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
