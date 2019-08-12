package com.base;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * @author LiuPeng
 * @description 代码块的顺序
 * @date 2019/7/18
 */
public class CodeSortTest {

    /*public static void main(String[] args) {
        Father father = new Son();
    }*/

    public static void main(String[] args) {
        //Collator类是用来执行区分语言环境的String比较的，这里是选择CHINA
        Comparator comparator = Collator.getInstance(Locale.CHINA);
        String[] a = {"安保","乔飞", "687","乔巴", "路飞","Cat", "张无忌", "cat","小龙女", "123","史蒂芬","HeHe"};
        //使根据指定比较器产生的顺序对指定对象数组进行排序
        Arrays.sort(a, comparator);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /** 输出
     父类代码块
     子类代码块
     父类普通代码块
     父类构造方法
     子类普通代码块
     子类构造方法
    */
}
