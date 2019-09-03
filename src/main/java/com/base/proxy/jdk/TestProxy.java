package com.base.proxy.jdk;

import com.base.proxy.FangBen;
import com.base.proxy.IFangBen;

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
        // 注意返回值为接口,jdk的动态代理是实现接口的类的代理
        IFangBen fangBen = (IFangBen) Proxy.newProxyInstance(fang.getClass().getClassLoader(), fang.getClass().getInterfaces(), handler);
        fangBen.checkFang();
    }
}
