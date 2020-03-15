package com.spring.aop.jdkProxy;

/**
 * @Author: liupeng
 * @DateTime: 2020/3/15 19:04
 * @Description: TODO
 */
public class UserDaoProxy implements IUserDao {

    private IUserDao userDao;

    public UserDaoProxy(IUserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public int save() {
        System.out.println("开启事务");
        userDao.save();
        System.out.println("结束事务");
        return 1;
    }
}
