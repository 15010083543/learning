package com.base.computer;

import java.math.BigDecimal;

/**
 * @Author: liupeng
 * @DateTime: Created in 2020/8/15 10:24
 * @version: 1.0
 * @Description: TODO
 */
public class BaseTest {

    public static void main(String[] args) {
       Long a = null;
       if (null == a) {
           System.out.println(111);
       }

        // 查看计算机有几核CPU
        System.out.println(Runtime.getRuntime().availableProcessors());

        Thread.State state = Thread.State.BLOCKED;

        String toPrice = "9999999";
        String multiply = new BigDecimal(toPrice).divide(new BigDecimal(10000)).toString();
        /*int i = bigDecimal * 10000;
        Double d = Double.parseDouble(toPrice) * 10000;*/
        System.out.println(multiply);
    }
}
