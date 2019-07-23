package com.base;

/**
 * @author LiuPeng
 * @description
 * @date 2019/7/23
 */
public class SonInterface implements FatherInterface{

    @Override
    public Father get() {
        Son son = new Son();
        son.setLove("aa");
        son.setAge(12);
        son.setName("liu");
        return son;
    }
}
