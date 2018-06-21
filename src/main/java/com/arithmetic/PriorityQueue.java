package com.arithmetic;
/**
 * @author LiuPeng
 * @description 优先级队列(相当于排序)
 * @date 2018/6/3
 */
public class PriorityQueue {
    private int maxSize;
    private int[] queue;
    private int nItem;

    public PriorityQueue(int size){
        maxSize = size;
        queue = new int[maxSize];
        nItem = 0;
    }

    public void insert(int num) {
        int i = 0;
        if (nItem == 0) {
            queue[nItem++] = num;
        } else {
            for (i = nItem-1; i >= 0 ; i--) {
                if (num > queue[i]) {
                    queue[i+1] = queue[i];
                } else
                    break;
            }
            queue[i+1] = num;
            nItem++;
        }
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(5);
        queue.insert(1);
        queue.insert(13);
        queue.insert(12);

        queue.insert(15);
        System.out.println("-----");
    }
}
