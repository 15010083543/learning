package com.base.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author LiuPeng
 * @description cglib动态代理
 * @date 2019/9/3
 */
public class CglibProxy implements MethodInterceptor {

    private Object targetObj;

    // 创建代理对象
    public Object createProxyObj(Object obj){
        this.targetObj = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        Object proxyObj = enhancer.create();
        return proxyObj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("权限校验");
        Object object = method.invoke(targetObj, objects);
        return object;
    }


}
