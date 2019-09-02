package com.designPattens.decoratePatten;

/**
 * @author LiuPeng
 * @description 彩铃装饰器
 * @date 2019/9/2
 */
public class RingDecorate extends Decorate {

    private Telephone telephone;

    public RingDecorate(Telephone telephone){
        this.telephone = telephone;
    }

    @Override
    public void call() {
        System.out.println("---彩铃---");
        telephone.call();
    }
}
