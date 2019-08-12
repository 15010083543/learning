package com.arithmetic.link;

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

}
