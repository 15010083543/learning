package com.base.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author LiuPeng
 * @description 代理类
 * @date 2019/9/2
 */
public class ProwerProxyHandle implements InvocationHandler {

    private Object target;
    public ProwerProxyHandle(Object object){
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("是否为管理员校验");
        Object proxyObject = method.invoke(target, args);
        return proxyObject;
    }
}
