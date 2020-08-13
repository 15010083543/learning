package com.arithmetic.map;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: liupeng
 * @DateTime: 2020/3/21 16:56
 * @Description: TODO
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map = new ConcurrentHashMap<>();
        map.put(null, null);
        map.put("1", "2");
        map.put("22", "2");
        map.put("12", "3");
        map.put("11", "4");
        map.forEach((key, value) -> System.out.println(key+":"+value));

        Map<String, String> hashtable = new Hashtable<>();
        hashtable.put(null, null);
        hashtable.put("11", "22");
        hashtable.forEach((key, value) -> System.out.println(key+":"+value));
    }
}
