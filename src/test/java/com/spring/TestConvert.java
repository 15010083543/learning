package com.spring;

import com.spring.ioc.ConvertFactory;
import com.spring.ioc.ListConvert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: liupeng
 * @DateTime: 2020/3/30 14:30
 * @Description: TODO
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/config/applicationContext.xml"})
public class TestConvert {

   @Autowired
   private ConvertFactory convertFactory;

   @Test
    public void testlist() {
        ListConvert listConvert = convertFactory.getListConverter("ajk", 2);
        System.out.println(listConvert);
    }
}
