package com.designPattens.proxyPatten;

/**
 * @author LiuPeng
 * @description 调用代理类
 * @date 2018/11/24
 */
public class XiMenQin {

    public static void main(String[] args) {
        // 西门庆把王婆叫出来
        WangPo wangPo = new WangPo(new PanJinLian());
        wangPo.happyWithMan();
        wangPo.makeEyesWithMan();
    }
}
