package com.base.proxy.cglib;


import com.base.proxy.FangBen;
import com.base.proxy.IFangBen;

/**
 * @author LiuPeng
 * @description 代理测试类
 * @date 2019/9/2
 */
public class TestCglibProxy {

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        IFangBen proxyObj = (IFangBen)cglibProxy.createProxyObj(new FangBen());
        proxyObj.checkFang();
    }
}
