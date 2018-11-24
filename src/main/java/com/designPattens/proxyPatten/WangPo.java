package com.designPattens.proxyPatten;

/**
 * @author LiuPeng
 * @description 代理类(王婆)
 * @date 2018/11/24
 */
public class WangPo implements KindWoman {

    private KindWoman kindWoman;

    public WangPo(){
        this.kindWoman = new PanJinLian(); // 默认是潘金莲
    }

    public WangPo (KindWoman kindWoman) {
        this.kindWoman = kindWoman;
    }

    @Override
    public void makeEyesWithMan() {
        kindWoman.makeEyesWithMan();
    }

    @Override
    public void happyWithMan() {
        kindWoman.happyWithMan();
    }
}
