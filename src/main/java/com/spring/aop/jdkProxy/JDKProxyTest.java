package com.spring.aop.jdkProxy;

import org.junit.Test;

/**
 * @Author: liupeng
 * @DateTime: 2020/3/15 19:06
 * @Description: TODO
 */
public class JDKProxyTest {

    @Test
    public void testProxy(){
        IUserDao userDao = new UserDaoImpl();
        IUserDao userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();
    }

}
