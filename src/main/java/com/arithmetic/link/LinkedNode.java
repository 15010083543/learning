package com.arithmetic.link;
import lombok.Data;

/**
 * @author LiuPeng
 * @description 链表结构
 * @date 2019/8/12
 */
@Data
public class LinkedNode {

    public int num;
    public LinkedNode next;

    public LinkedNode(int num, LinkedNode next) {
        this.num = num;
        this.next = next;
    }

    public LinkedNode() {
    }

    public LinkedNode(int num) {
        this.num = num;
    }

    /*
    *@description 尾部插入链表
    *@param linkedNode 原始链表
    *@param num 新节点
    *@return void
    */
    public static LinkedNode insertLastLinked(LinkedNode linkedNode, int num) {
        if (null == linkedNode) {
            linkedNode = new LinkedNode(num);
        } else {
            LinkedNode newNode = new LinkedNode(num);
            LinkedNode flag = linkedNode;
            while (true) {
                if (null == flag.next) {
                    flag.setNext(newNode);
                    break;
                } else {
                    flag = flag.next;
                }
            }
        }
        return linkedNode;
    }

    /*
     *@description 头部插入链表
     *@param linkedNode 原始链表
     *@param num 新节点
     *@return void
     */
    public static LinkedNode insertFirstLinked(LinkedNode linkedNode, int num) {
        LinkedNode newNode = new LinkedNode(num);
        if (null != linkedNode) {
            newNode.setNext(linkedNode);
        }
        linkedNode = newNode;
        return linkedNode;
    }

    /*
     *@description 链表删除节点
     *@param linkedNode 原始链表
     *@param num 新节点
     *@return void
     */
    public static LinkedNode deleteNode(LinkedNode linkedNode, int num) {
        if (null == linkedNode) {
            return null;
        }
        // 删除头节点
        if (linkedNode.getNum() == num) {
            return linkedNode.getNext();
        }
        LinkedNode flag= linkedNode;
        // 删除普通节点
        while (null !=flag.getNext()) {
            if (flag.getNext().getNum() == num){
                flag.setNext(flag.getNext().getNext());
                break;
            } else {
                flag = flag.getNext();
            }
        }
        return linkedNode;
    }

    public static int getCount(LinkedNode linkedNode){
        int count = 0;
        LinkedNode flag = linkedNode;
        while (null != flag) {
            ++ count;
            flag = flag.getNext();
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedNode linkedNode = new LinkedNode(1);
        insertLastLinked(linkedNode, 2);
        LinkedNode linkedNode1 = insertLastLinked(linkedNode, 3);
        LinkedNode insertFirst = insertFirstLinked(linkedNode1, 0);
        System.out.println(getCount(insertFirst));
        System.out.println((insertFirst));
        LinkedNode linkedNode3 = deleteNode(insertFirst, 2);
        System.out.println((linkedNode3));
        LinkedNode linkedNode2 = deleteNode(insertFirst, 0);
        System.out.println((linkedNode2));
    }
}
