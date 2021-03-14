package com.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

public class RedisUtil {
    private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    private static JedisPool pool = null;

    static {
        try {
            // 数据库链接池配置
            JedisPoolConfig config = new JedisPoolConfig();
            //最大连接数, 应用自己评估，不要超过Redis每个实例最大的连接数
            config.setMaxTotal(100);
            //最大空闲连接数, 应用自己评估，不要超过Redis每个实例最大的连接数
            config.setMaxIdle(50);
            config.setMinIdle(20);
            config.setMaxWaitMillis(6 * 1000);
            // 是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个
            config.setTestOnBorrow(true);
            // 在空闲时检查有效性, 默认false
            config.setTestWhileIdle(true);
            // 是否进行有效性检查
            config.setTestOnReturn(false);

            //域名
            String host = "127.0.0.1";//PropertyUtil.getString("redis_host");
            //密码
            String password = "";//PropertyUtil.getString("redis_password");
            //端口
            int port = 6379;//PropertyUtil.getInteger("redis_port");
            //建立连接超时时间
            int timeout = 3000;
            pool = new JedisPool(config, host, port, timeout, password);
        } catch (Exception e) {
            logger.error("redis初始化失败", e);
        }
    }

    public static Jedis getRedis() {
        try {
            if (null != pool) {
                return pool.getResource();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public static String get(String key) {
        Jedis jedis = getRedis();
        try {
            return jedis.get(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            closeJedis(jedis);
        }
        return null;
    }

    public static void set(String key, String value) {
        Jedis jedis = getRedis();
        try {
            jedis.set(key, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            closeJedis(jedis);
        }
    }

    /**
     * 添加设置过期时间
     *
     * @param key
     * @param value
     * @param seconds
     */
    public static void setEx(String key, String value, int seconds) {
        Jedis jedis = getRedis();
        try {
            jedis.setex(key, seconds, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            closeJedis(jedis);
        }
    }

    public static void setEx(String key, JSONObject value, int seconds) {
        setEx(key, JSON.toJSONString(value), seconds);
    }

    public static void del(String key) {
        Jedis jedis = getRedis();
        try {
            jedis.del(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            closeJedis(jedis);
        }
    }

    public static void sadd(String key, String value) {
        Jedis jedis = getRedis();
        try {
            jedis.sadd(key, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            closeJedis(jedis);
        }
    }

    public static Boolean sismember(String key, String value) {
        Jedis jedis = getRedis();
        try {
            return jedis.sismember(key, value);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        } finally {
            closeJedis(jedis);
        }
    }

    public static List<String> lrange(String key, Long start, Long end) {
        Jedis jedis = getRedis();
        try {
            return jedis.lrange(key, start, end);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        } finally {
            closeJedis(jedis);
        }
    }

    /**
     * 对某个key 做 自增,并设置过期时间
     *
     * @param key
     * @param cacheSeconds
     * @return
     */
    public static long setIncr(String key, int cacheSeconds) {
        Jedis jedis = getRedis();
        long result = 0;
        try {
            result = jedis.incr(key);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            closeJedis(jedis);
        }
        return result;
    }

    /**
     * 对某个key 做 自增 count,并设置过期时间
     *
     * @param key
     * @param count
     * @param cacheSeconds
     * @return
     */
    public static long setIncrByCount(String key, int count, int cacheSeconds) {
        Jedis jedis = getRedis();
        long result = 0;
        try {
            result = jedis.incrBy(key, count);
            if (cacheSeconds != 0) {
                jedis.expire(key, cacheSeconds);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            closeJedis(jedis);
        }
        return result;
    }

    public static void closeJedis(Jedis jedis) {
        try {
            if (null != jedis) {
                jedis.close();
            }
        } catch (Exception e) {
            logger.error("jedis close 异常, e, ", e);
        }
    }

    // 插入数据并设置过期时间
    public static void rpush(String key, String value, int time) {
        Jedis jedis = getRedis();
        try {
            jedis.rpush(key, value);
            jedis.expire(key, time);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            closeJedis(jedis);
        }
    }

    public static void expire(String key, int time) {
        Jedis jedis = getRedis();
        try {
            jedis.expire(key, time);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            closeJedis(jedis);
        }
    }

    // 获取集合对象
    public static List<String> listReidsData(String key) {
        List<String> list = null;
        Jedis jedis = getRedis();
        try {
            list = jedis.lrange(key, 0, -1);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            closeJedis(jedis);
        }
        return list;
    }

    // 是否包含某个对象
    public static boolean exist(String key, String helpuserId) {
        Boolean sismember = false;
        Jedis jedis = getRedis();
        try {
            sismember = jedis.sismember(key, helpuserId);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            closeJedis(jedis);
        }
        return sismember;
    }

    /**
     * 根据 cityListName 获取 redis 中 当前城市seo导航页底部城市链接 对应的key
     *
     * @param cityListName
     * @return
     */
    public static String builderBottomNavigationVoListKey(Object cityListName) {
        StringBuilder builder = new StringBuilder();
        builder.append(cityListName).append("-").append("bottomNavigationVoList");
        return builder.toString();
    }


}