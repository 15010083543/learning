package com.base.proxy;

/**
 * @author LiuPeng
 * @description 房本
 * @date 2019/9/2
 */
public class FangBen implements IFangBen{

    @Override
    public void checkFang() {
        System.out.println("房本校验");
    }
}
