package com.util;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @Author: liupeng
 * @DateTime: Created in 2021/3/12 15:37
 * @version: 1.0
 * @Description: TODO
 */
public class RedissionUtil {

    public static void main(String[] args) {
       /* Config config = new Config();
        config.useClusterServers()
                .setScanInterval(2000) // cluster state scan interval in milliseconds
                .addNodeAddress("redis://127.0.0.1:6379");*/

        Config config = new Config();
        config.useSingleServer().setAddress("127.0.0.1:6379");

        RedissonClient redisson = Redisson.create(config);


        RLock lock = redisson.getLock("anyLock");

        lock.lock(100, TimeUnit.SECONDS);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
