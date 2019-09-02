package com.designPattens.decoratePatten;

/**
 * @author LiuPeng
 * @description 装饰模式的测试类
 * @date 2019/9/2
 */
public class TestPhone {

    public static void main(String[] args) {
        Telephone phone = new Iphone();
        phone.call();
        System.out.println("---------------------");
        // 听音乐
        MusicDecorate musicDecorate = new MusicDecorate(phone);
        musicDecorate.call();
        // 听彩铃
        RingDecorate ringDecorate = new RingDecorate(phone);
        ringDecorate.call();
        System.out.println("---------------------");
        // 先听彩铃，打电话，听音乐
        Telephone telephone = new RingDecorate(new MusicDecorate(phone));
        telephone.call();
    }
}
