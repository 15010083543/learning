package com.spring;

import com.common.Man;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiuPeng
 * @description IOC学习
 * @date 2018/11/23
 */
public class Bean {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Man man = (Man) ac.getBean("man");
        System.out.println(man.toString());
    }

}
