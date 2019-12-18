package com.base;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @author LiuPeng
 * @description
 * @date 2019/9/23
 */
public class TestMap {

    @Test
    public void Test(){
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.SECOND));
        System.out.println(new Date().getSeconds());
      /*  Map<Integer, String> map = new HashMap<>(10);
        map.put(7, "2");
        map.put(11, "3");
        map.put(43, "1");
        map.put(59, "1");
        map.put(19, "");
        map.put(3, "");
        map.put(352, "");
        map.put(592, "2");
        map.put(192, "");
        map.put(322, "");
        map.put(35, "");
        map.put(591, "2");
        map.put(191, "");
        map.put(31, "");
        map.put(351, "");
        map.get(19);
        map.get(3);
        for (HashMap.Entry key : map.entrySet()) {
            System.out.println(key.getKey() + " -> " + key.getValue());
        }*/
        /*System.out.println(1);
        Set<String> strings = map.keySet();
        strings.stream().forEach(x -> System.out.println(x + ":" + map.get(x)));*/

    }
}
