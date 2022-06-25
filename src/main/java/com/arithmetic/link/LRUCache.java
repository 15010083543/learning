package com.arithmetic.link;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiuPeng
 * @description 缓存LRU策略算法
 * 面试：双链表 + hashtable实现原理：
 * @date 2019/12/20
 */
public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }






    private static final int COUNTTOTAL = 5;

    public static void main(String[] args) {
        LinkedNode linkedNode = new LinkedNode(1);
        LinkedNode linkedNode1 = LinkedNode.insertFirstLinked(linkedNode, 2);
        LinkedNode linkedNode2 = LinkedNode.insertFirstLinked(linkedNode1, 3);
        LinkedNode linkedNode3 = LinkedNode.insertFirstLinked(linkedNode2, 4);
        LinkedNode linkedNode4 = LinkedNode.insertFirstLinked(linkedNode3, 5);
        LinkedNode addNode = new LinkedNode(6);
        /*int count = LinkedNode.getCount(linkedNode4);
        addNode.setNext(linkedNode4);
        System.out.println(addNode);
        if (++count > COUNTTOTAL) {
            deleteNode(addNode);
        }
        System.out.println(addNode);*/
        System.out.println(LRUTest(linkedNode4, addNode));
    }


    public static LinkedNode LRUTest(LinkedNode linkedNode, LinkedNode select){
        if (null == linkedNode) {
            return select;
        }
        LinkedNode pre = select;
        int count = 1;
        select.next = linkedNode;
        LinkedNode cur = select;
        while (null != cur.next) {
            cur = cur.next;
            //pre = pre.next
            ++count;
            if (count == 3) {
                cur.next = null;
                break;
            }
        }
        return cur;
    }

    /*
    *@description 删除尾节点
    *@param null
    *@return
    */
    public static void deleteNode(LinkedNode addNode) {
        LinkedNode falg = addNode;
        while (null != falg.getNext()) {
            falg = falg.getNext();
        }
        // 找到尾节点
        LinkedNode last = falg;
        falg = addNode;
        while (last != falg.getNext()) {
            falg = falg.getNext();
        }
        // 找到尾节点的上一个节点
        LinkedNode preLast = falg;
        preLast.setNext(null);

    }

}
