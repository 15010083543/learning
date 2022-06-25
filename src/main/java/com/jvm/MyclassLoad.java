package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 *
 * @author liupeng
 * @version 1.0
 * @date 2022/04/25 20:19:10
 */
public class MyclassLoad extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        List list = new ArrayList<Integer>();
        list.add(1);
        return super.findClass(name);
    }


}
