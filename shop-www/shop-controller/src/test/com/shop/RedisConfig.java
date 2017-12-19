package com.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * Created by 17173 on 2017/12/8.
 */
@Configuration
public class RedisConfig {
    @Bean
    public static RedisConnectionFactory jedisConnectionFactory(){
        //mymaster室哨兵监控的主服务器名称 ..sentinel()..这是添加一个哨兵
        RedisSentinelConfiguration sentinelConfiguration=new RedisSentinelConfiguration().master("mymaster").sentinel("127.0.0.1",26380);
        //把哨兵添加到连接工厂
        JedisConnectionFactory connectionFactory=new JedisConnectionFactory(sentinelConfiguration);
        //设置主服务器密码
        connectionFactory.setPassword("123456");
        return connectionFactory;
    }
}
