package com.base;

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
        Map<String, Integer> map = new HashMap<>();
        map.put("1a", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("7", 7);
        map.put("4a", 4);
        map.put("6", 6);
        map.put("5a", 5);
        Set<String> strings = map.keySet();
        strings.stream().forEach(x -> System.out.println(x + ":" + map.get(x)));

    }
}
