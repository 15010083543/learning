package com.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author LiuPeng
 * @description 代理测试类
 * @date 2019/9/2
 */
public class TestProxy {

    public static void main(String[] args) {
        FangBen fang = new FangBen();
        InvocationHandler handler = new ProwerProxyHandle(fang);
        IFangBen fangBen = (IFangBen) Proxy.newProxyInstance(fang.getClass().getClassLoader(), fang.getClass().getInterfaces(), handler);
        fangBen.checkFang();
    }
}
