package com.resume;

import java.util.Arrays;
import java.util.Random;

//北京市小汽车摇号，每个人有不同的中签倍率。完成下面的getWinners方法，实现一个摇号算法，返回指定个数量（number）的中签者ID。（请注意中签者有概率因素，倍率高者不一定中，只是概率升至factor倍）。

public class Person {
     
    private String id;//摇号者ID
    private Integer factor;//中签倍率
     
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getFactor() {
        return factor;
    }
    public void setFactor(Integer factor) {
        this.factor = factor;
    }

    public static void main(String[] args) {
        //定义一个长度为20的Person数组
        Person[] persons = new Person[20];
        //添加假数据
        for (int i = 0; i < 20; i++) {
            Person p = new Person();
            p.setId(String.valueOf(i));
            p.setFactor(i);
            persons[i] = p;
        }
        String[] winners = getWinners(persons, 3);
        System.out.println(Arrays.toString(winners));
    }
     
    /**
     * 实现一个摇号算法，返回指定个数量（number）的中签者ID。
     * （请注意中签有概率因素，倍率高者不一定中，只是概率升至factor倍）
     * @param persons
     * @param number
     */
    public static String[] getWinners(Person[] persons, int number) {
        //返回[0,20]之间的随机数，不包括20
        Random rand = new Random();
        int i = rand.nextInt(20);
        //中奖人数
        int num = 0;
        String[] winners = new String[number];
        System.out.println("i = " + i);
        //循环摇号总人数
        for (int j = 0; j  < persons.length; j++) {
            //中奖倍率
            int factor = persons[j].getFactor();
             
            if (i < factor) {
                if (num >= number) {
                    break;
                }
                //添加到中奖数组
                winners[num] = persons[j].getId();
                num++;
            }
        }        
        return winners;
    }
}