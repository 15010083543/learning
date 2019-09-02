package com.designPattens.decoratePatten;

/**
 * @author LiuPeng
 * @description 具体的手机类
 * @date 2019/9/2
 */
public class Iphone implements Telephone {
    @Override
    public void call() {
        System.out.println("---打电话---");
    }
}
