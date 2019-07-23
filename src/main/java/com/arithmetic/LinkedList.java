package com.arithmetic;

/**
 * @author LiuPeng
 * @description 单项链表
 * @date 2018/6/5
 */
public class LinkedList {

    private int num; // 元素
    private LinkedList next; // 指针

    private LinkedList head = null; // 头节点

    private LinkedList cur = null; // 当前节点


    public LinkedList() {
    }

    public LinkedList(int num) {
        this.num = num;
    }

    // 链表头部添加元素
    public void add(LinkedList link, LinkedList linkedList) {
        if (linkedList.head == null) {
            linkedList.head = link;
        } else {
            cur = linkedList.head; // 先把头节点赋值给当前节点
            linkedList.head = link; // 把要添加的元素赋值给头节点
            linkedList.next = cur; // 把当前节点赋值给头节点的下一个节点
        }
    }

    // 链表尾部添加元素
    public void append(LinkedList linkedList, LinkedList tmp) {
        if (null == linkedList.head) {
            linkedList.head = linkedList;
        } else {
            cur = linkedList.head;
            while (null != cur) {
                cur = cur.next;
            }
             linkedList.next = tmp;
        }

    }

    // 链表指定位置添加元素
    public void insert(int pos, LinkedList linkedList) {

    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList link1 = new LinkedList(1);
        LinkedList link2 = new LinkedList(2);
        LinkedList link3 = new LinkedList(3);
        linkedList.add(link1, linkedList);
        linkedList.add(link2, linkedList);
        System.out.println("-------------");
        linkedList.add(link3, linkedList);
        LinkedList link4 = new LinkedList(4);
        linkedList.append(linkedList, link4);
        linkedList.travel(linkedList);
        //System.out.println(linkedList.isEmpty());
        //System.out.println(linkedList.length());
    }

    public boolean isEmpty() {
        return head == null;
    }
    public int length() {
        int count = 0;
        while (null != head) {
            head = head.next;
            count ++;
        }
        return count;
    }

    // 便利
    public void travel(LinkedList linkedList) {
        while (null != linkedList.head){
            System.out.println(linkedList.head.num);
            linkedList.cur = linkedList.head.next;
            linkedList.head = linkedList.cur;
        }
    }

    // 删除节点
    public void remove(LinkedList linkedList) {

    }

    // 查找节点是否存在
    public boolean search(LinkedList linkedList) {

        return false;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }

    public LinkedList getHead() {
        return head;
    }

    public void setHead(LinkedList head) {
        this.head = head;
    }

    public LinkedList getCur() {
        return cur;
    }

    public void setCur(LinkedList cur) {
        this.cur = cur;
    }
}
