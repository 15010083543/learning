package com.spring.aop.jdkProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: liupeng
 * @DateTime: 2020/3/15 19:09
 * @Description: JDK 动态代理实现
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private Object target;
    public InvocationHandlerImpl(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        System.out.println("开启事务");
        Object result = method.invoke(target, args);
        System.out.println("结束事务");
        return result;
    }

    public static void main(String[] args){
        try {
            IUserDao userDao = new UserDaoImpl();
            InvocationHandler invocationHandlerImpl = new InvocationHandlerImpl(userDao);
            // 类加载器
            ClassLoader classLoader = userDao.getClass().getClassLoader();
            // 一组接口
            Class<?>[] interfaces = userDao.getClass().getInterfaces();
            IUserDao userDaoProxy = (IUserDao) Proxy.newProxyInstance(classLoader, interfaces, invocationHandlerImpl);
            int save = userDaoProxy.save();
            System.out.println("----------------------" + save);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}
