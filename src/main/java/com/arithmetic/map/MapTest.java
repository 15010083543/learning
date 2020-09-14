package com.arithmetic.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: liupeng
 * @DateTime: 2020/3/21 16:56
 * @Description: TODO
 */
public class MapTest {

    public static void main(String[] args) {

        Map<String, String> map = new LinkedHashMap<>();
        //map = new ConcurrentHashMap<>();
        //map.put(null, null); // ConcurrentHashMap 不接受null key和null value
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("112", "5");
        map.put("113", "6");
        map.put("114", "7");
        map.put("115", "8");
        map.put("116", "9");
        map.put("117", "10");
        map.put("118", "11");
        map.put("119", "12");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            if (next.getValue().equals("4")) {
                iterator.remove();
            }if (next.getValue().equals("7")) {
                iterator.remove();
            }if (next.getValue().equals("9")) {
                iterator.remove();
            }
        }
        map.forEach((key, value) -> System.out.println(key+":"+value));




        /*Map<String, String> hashtable = new Hashtable<>();
        hashtable.put(null, null);
        hashtable.put("11", "22");
        hashtable.forEach((key, value) -> System.out.println(key+":"+value));*/
    }
}
