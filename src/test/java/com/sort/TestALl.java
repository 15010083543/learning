package com.sort;

import java.util.HashMap;

/**
 * @author LiuPeng
 * @description
 * @date 2018/12/3
 */
public class TestALl {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("q", 1);
        int h = 0;
        String key = "q";
        System.out.println((key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16));
        int b = 9;
    }

    private  int hash = 0;
    private final char value[] = {'q'} ;
    public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }
}
