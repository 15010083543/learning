package com.designPattens.decoratePatten;

/**
 * @author LiuPeng
 * @description 音乐装饰器
 * @date 2019/9/2
 */
public class MusicDecorate extends Decorate {

    private Telephone telephone;

    public MusicDecorate(Telephone telephone){
        this.telephone = telephone;
    }

    @Override
    public void call() {
        telephone.call();
        System.out.println("---音乐---");
    }
}
