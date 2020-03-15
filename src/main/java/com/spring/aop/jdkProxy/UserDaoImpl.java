package com.spring.aop.jdkProxy;

/**
 * @Author: liupeng
 * @DateTime: 2020/3/15 19:03
 * @Description: TODO
 */
public class UserDaoImpl implements IUserDao {

    @Override
    public int save() {
        System.out.println("------save------------");
        return 1;
    }
}
