package com.classload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author LiuPeng
 * @description 类加载器
 *
 * 自定义类加载器
 *      1.定义一个类，继承CLassLoader
 *      2.重写loadClass方法
 *      3.实例化Class对象
 * @date 2018/8/12
 */
public class LoadTest{

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader cl = new ClassLoader(){
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".")) +" class";
                InputStream stream = getClass().getResourceAsStream(fileName);
                if (stream == null) {
                    return super.loadClass(name); // 父类加载器
                } else {
                    try {
                        byte[] bytes = new byte[stream.available()];
                        stream.read(bytes);
                        return defineClass(name, bytes, 0, bytes.length);
                    } catch (IOException e) {
                        throw  new ClassNotFoundException();
                    }
                }
            }
        };
        Object obj = cl.loadClass("com.classload.LoadTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof LoadTest);
    }

}
