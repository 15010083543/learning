package com.resume;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

/**
 * @Author: liupeng
 * @DateTime: Created in 2021/3/9 11:16
 * @version: 1.0
 * @Description: sorted set（zset）排行榜
 */
public class ZsetTest {
    public static void main(String[] args) {

        // 1.给服务器编号
        //实例化一个客户端
        Jedis jedis = new Jedis("localhost");
        jedis.zincrby("0309", 1,"1802593510941");
        jedis.zincrby("0309", 1,"180259351");
        jedis.zincrby("0308", 1,"1802593512");
        jedis.zincrby("0309", 1,"1802593512");
        jedis.zincrby("0308", 1,"180259351");
        jedis.zincrby("0307", 6,"1802");
        // 某一个key的排名
        Set<Tuple> set = jedis.zrevrangeWithScores("0309", 0, 9);
        for (Tuple tuple: set) {
            System.out.println(tuple.getElement());
            System.out.println(tuple.toString());
        }
        System.out.println("===========");
        // 3天的一个总排名，把结果赋值给“12-15”这个key
        Long key = jedis.zunionstore("12-15", "3", "0309", "0308", "0307");
        Set<Tuple> sets = jedis.zrevrangeWithScores("12-15", 0, 9);
        for (Tuple tuple: sets) {
            System.out.println(tuple.getElement());
            System.out.println(tuple.toString());
        }
        // 查看自己的排名
        System.out.println(jedis.zrevrank("12-15", "1802"));
        System.out.println(jedis.zrevrank("12-15", "180259351"));
        System.out.println(jedis.zrevrank("12-15", "1802593512"));
        System.out.println(jedis.zrevrank("12-15", "1802593510941"));

    }
}
