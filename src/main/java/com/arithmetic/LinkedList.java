package com.arithmetic;
/**
 * @author LiuPeng
 * @description 链表
 * @date 2018/6/5
 */
public class LinkedList {
    private int age;
    private String name;
    private LinkedList next;
    private LinkedList first;

    public LinkedList() {
    }

    public LinkedList(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    // 插入 插入到第一个位置最简单
    public void insertFirst(int age, String name) {
        LinkedList link = new LinkedList(age, name);
        link.next = first;
        first = link;
    }

    // 删除第一个元素
    public LinkedList deletFirst(){
        LinkedList tmp = first;
        first = first.next;
        return tmp;
    }

    // 查找某一个元素
    public LinkedList find(int age){
        LinkedList link = first;
        while (link.age != age){
            if (link.next == null) {
                return null;
            }
            link = link.next;
        }
        return link;
    }

    // 删除某一个元素
    public LinkedList delete(int age){
        LinkedList link = first;
        LinkedList preLink = null;
        while (link.age != age){
            if (link.next == null) {
                return null;
            } else {
                preLink = link;
                link = link.next;
            }
        }
        if (preLink != null) {
            preLink.next = link.next;
        } else {
            first = link.next;
        }
        return link;
    }


    public static void main(String[] args) {
        LinkedList link = new LinkedList();
        for (int i = 0; i < 3 ; i++) {
            link.insertFirst(i, "test"+i);
        }

        System.out.println(link.find(2));
        System.out.println("-------------------------" );
        System.out.println(link.delete(1));
        System.out.println("-------------------------" );
        link.deletFirst();
        // 下面的循环导致link变成最后一个元素
        if (link.first != null) {
            System.out.println(link.first);
            link = link.first;
            while (link.next != null){
                System.out.println(link.next.toString());
                link = link.next;
            }
        }
    }
}
