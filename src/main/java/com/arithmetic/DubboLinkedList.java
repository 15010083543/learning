package com.arithmetic;

import java.util.LinkedList;
import java.util.List;

/**
 * @author LiuPeng
 * @description 双向链表(双端双向列表)
 * @date 2018/6/7
 */
public class DubboLinkedList {
    private int num;
    private DubboLinkedList last;// 最后一个
    private DubboLinkedList first;// 第一个
    private DubboLinkedList pre;// 上一个
    private DubboLinkedList next;// 下一个

    public DubboLinkedList() {
    }

    public DubboLinkedList(int num){
        this.num = num;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFrist(int num){
        DubboLinkedList link = new DubboLinkedList(num);
        if (isEmpty()) {// 链表是否为空
            last = link;
        } else {
            first.pre = link;
        }
        link.next = first;
        first = link;
    }

    public void insertLast(int num){
        DubboLinkedList link = new DubboLinkedList(num);
        if (isEmpty()) {// 链表是否为空
            first = link;
        } else {
            last.next = link;
            link.pre = last;
        }
        last = link;

    }

    public DubboLinkedList deleteFrist(){
        DubboLinkedList link = first;
        if (!isEmpty()) {// 链表是否为空
            first = first.next;
            first.pre = null;
        }
        return  link;
    }

    public DubboLinkedList deletelast(){
        DubboLinkedList link = last;
        if (!isEmpty()) {// 链表是否为空
            last = last.pre;
            last.next = null;
        }
        return link;
    }


    // 插入到某一个节点的后面
    public boolean insertAfter(int key, int num){
       /* 自己coding
       DubboLinkedList linkedList = new DubboLinkedList(num);
        DubboLinkedList insertKey = null; // 插入的位置
        DubboLinkedList current = first; // 当前节点
        if (!isEmpty()) {
            if (first.num == key) {
                insertKey = first;
            } else {
                while(current != null){
                    if (current.num == key) {
                        insertKey = current;
                        break;
                    } else {
                        current = current.next;
                    }
                }
            }
        }
        if (insertKey != null) {
            next = insertKey.next;
            insertKey.next = linkedList;
            linkedList.pre = first;
            linkedList.next = null;
            if (next != null) {
                linkedList.next = next;
                next.pre = linkedList;
            }
            return true;
        }
        return false;
        */
       // book coding
        //1. 找到要插入的位置
        DubboLinkedList current = first; // 当前节点
        while (current.num != key) {
            current = current.next;
            if (current == null) {
                return false;
            }
        }
        // 2.创建元素
        DubboLinkedList linkedList = new DubboLinkedList(num);
        // 3.插入元素
        if (current == last) { // 如果插入的是最后一位
            linkedList.next = null;
            last = linkedList;
        } else {
            current.next.pre = linkedList;
            linkedList.next = current.next;
        }
        current.next = linkedList;
        linkedList.pre = current;
        return true;
    }

    public void display() {
        DubboLinkedList linkedList = first;
        while (linkedList != null) {
            System.out.print(linkedList.num);
            linkedList = linkedList.next;
        }
    }


    public static void main(String[] args) {
        DubboLinkedList linkedList = new DubboLinkedList();
        for (int i = 0; i < 3; i++) {
            linkedList.insertFrist(i);
        }
       /* DubboLinkedList linkedList2 = new DubboLinkedList();
        for (int i = 0; i < 3; i++) {
            linkedList2.insertLast(i);
        }*/
        linkedList.insertAfter(1,5);
        /*linkedList.deleteFrist();
        linkedList.deletelast();*/
        linkedList.display();
    }
}
