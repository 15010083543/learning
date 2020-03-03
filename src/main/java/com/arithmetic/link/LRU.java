package com.arithmetic.link;

/**
 * @author LiuPeng
 * @description 缓存LRU策略算法
 * @date 2019/12/20
 */
public class LRU {

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
