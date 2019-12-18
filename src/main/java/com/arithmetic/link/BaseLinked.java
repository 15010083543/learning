package com.arithmetic.link;

import com.arithmetic.sort.InsertSort;
import lombok.Data;

/**
 * @author LiuPeng
 * @description 链表结构
 * @date 2019/8/12
 */
@Data
public class BaseLinked {

    public int num;
    public BaseLinked next;

    public BaseLinked(int num, BaseLinked next) {
        this.num = num;
        this.next = next;
    }

    public BaseLinked() {
    }

    public BaseLinked(int num) {
        this.num = num;
    }

    /*
    *@description 尾部插入链表
    *@param baseLinked 原始链表
    *@param num 新节点
    *@return void
    */
    public static BaseLinked insertLastLinked(BaseLinked baseLinked, int num) {
        if (null == baseLinked) {
            baseLinked = new BaseLinked(num);
        } else {
            BaseLinked newNode = new BaseLinked(num);
            BaseLinked flag = baseLinked;
            while (true) {
                if (null == flag.next) {
                    flag.setNext(newNode);
                    break;
                } else {
                    flag = flag.next;
                }
            }
        }
        return baseLinked;
    }

    /*
     *@description 头部插入链表
     *@param baseLinked 原始链表
     *@param num 新节点
     *@return void
     */
    public static BaseLinked insertFirstLinked(BaseLinked baseLinked, int num) {
        BaseLinked newNode = new BaseLinked(num);
        if (null != baseLinked) {
            newNode.setNext(baseLinked);
        }
        return newNode;
    }

    public static void main(String[] args) {
        BaseLinked baseLinked = new BaseLinked(1);
        insertLastLinked(baseLinked, 2);
        BaseLinked baseLinked1 = insertLastLinked(baseLinked, 3);
        BaseLinked insertFirst = insertFirstLinked(baseLinked1, 0);
        System.out.println(baseLinked1);
    }
}
