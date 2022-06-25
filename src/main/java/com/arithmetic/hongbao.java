package com.arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 描述
 * 二倍均值法
 * @author liupeng
 * @version 1.0
 * @date 2022/06/25 21:38:36
 */
public class hongbao {

    List<Integer> hongbao(int totalAmount, int totalNumber) {
        List<Integer> list = new ArrayList();
        if (totalAmount <= 0 || totalNumber<= 0) {
            return list;
        }
        for (int i = totalNumber; i >= 2; i--) {
            int x = (totalAmount << 1) / i; //二倍均值法
            int random = ThreadLocalRandom.current().nextInt(1, x);
            list.add(random);
            totalAmount -= random;
        }
        list.add(totalAmount);
        return list;
    }
}
