package com.arithmetic.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Author: liupeng
 * @DateTime: 2020/3/21 16:56
 * @Description: TODO
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        map.put("1", "2");
        map.forEach((key, value) -> System.out.println(key+":"+value));

        Map<String, String> hashtable = new Hashtable<>();
        hashtable.put(null, null);
        hashtable.put("11", "22");
        hashtable.forEach((key, value) -> System.out.println(key+":"+value));
    }
}
