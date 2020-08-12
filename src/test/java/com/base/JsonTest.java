package com.base;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @Author: liupeng
 * @DateTime: Created in 2020/6/2 17:17
 * @version: 1.0
 * @Description: TODO
 */
public class JsonTest {
    public static void main(String[] args) {

        String[] strArr = new String[] { "a", "b", "c" };
        String str = "c";
        boolean result = ArrayUtils.contains(strArr, str); // 推荐
        System.out.println(result); // true



        /*String str = new String("World");
        char ch[] = {'H','e','l','l','o'};
        change(str, ch);
        System.out.print(str + " and ");
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i]);
        }*/
       /* Short undergroundFloor = 1;
        Short abovegroundFloor= 2;
        System.out.println(undergroundFloor + abovegroundFloor);*/

    }
    private static void change(String str, char[] ch) {
        str = "Changed";
        ch[0] = 'C';
    }

        /*Integer a = 128;
        Integer b = 128;
        int c = 128;
        Long d = 128L;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(c == d);*/

        /*String str = "http://wgw8299.cnblogs.com/admin/";
        String domain = str.substring(0, str.lastIndexOf(".com")+1);
        System.out.println(domain);
        String domain1 = str.substring(0, str.indexOf(".com") + 4);
        System.out.println(domain1);*/
      /*  StringBuilder stringBuilder = new StringBuilder();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", 11);
        stringBuilder.append(jsonObject.toJSONString());
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("a", 11);
        stringBuilder.append(jsonObject2.toJSONString());

        JSONObject a = JSONObject.parseObject(stringBuilder.toString());
        System.out.println(a.toJSONString());*/
    //}
}

