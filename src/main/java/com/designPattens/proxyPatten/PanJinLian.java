package com.designPattens.proxyPatten;

/**
 * @author LiuPeng
 * @description 定义潘金莲是一个什么人
 * @date 2018/11/24
 */
public class PanJinLian implements KindWoman{

    @Override
    public void makeEyesWithMan() {
        System.out.println("潘金莲抛媚眼");
    }

    @Override
    public void happyWithMan() {
        System.out.println("潘金莲和那个男人在。。。。");
    }

}
