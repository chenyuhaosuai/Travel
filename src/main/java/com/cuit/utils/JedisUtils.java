package com.cuit.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.Properties;

public class JedisUtils {
    private static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        Properties properties = new Properties();
        try {
            properties.load(JedisUtils.class.getClassLoader().getResourceAsStream("redis.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("MAX_TOTAL")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("MAX_IDLE")));
        jedisPool = new JedisPool(jedisPoolConfig,properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    public static void retrunJedis(Jedis jedis){
        jedis.close();
    }
}
