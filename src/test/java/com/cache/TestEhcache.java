package com.cache;

import org.ehcache.UserManagedCache;
import org.ehcache.config.builders.UserManagedCacheBuilder;
import org.junit.Test;

/**
 * @author LiuPeng
 * @description
 * @date 2019/4/23
 */
public class TestEhcache {

    @Test
    public void test() {
        UserManagedCache<Integer, String> userManagedCache =
                UserManagedCacheBuilder.newUserManagedCacheBuilder(Integer.class, String.class)
                        .build(false);
        userManagedCache.init();

        for (int i=0;i<=2;i++){
            //写
            userManagedCache.put(i, "#"+i);
            //读
            String value = userManagedCache.get(i);
            System.out.println("get at "+i+":"+value);
            userManagedCache.put(i, "#"+20);
            String value2 = userManagedCache.get(i);
            System.out.println("get at "+i+":"+value2);
            System.out.println("---------------");
        }

        userManagedCache.close();
    }
}
