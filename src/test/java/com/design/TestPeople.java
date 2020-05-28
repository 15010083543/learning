package com.design;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liupeng
 * @DateTime: Created in 2020/5/27 10:43
 * @version: 1.0
 * @Description: TODO
 */
public class TestPeople {

    public static void main(String[] args) {
        Man people = new Man();
        people.setAge(1);
        people.setName("liu");
        List<People> p1 = new ArrayList<>();
        p1.add(people);
        String peopleStr = JSONObject.toJSONString(p1);

        List<Woman> infoVos = JSONObject.parseObject(peopleStr, new TypeReference<List<Woman>>() {
        });
        System.out.println("000000000");

    }
}
