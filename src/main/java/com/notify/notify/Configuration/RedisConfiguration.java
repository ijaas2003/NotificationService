package com.notify.notify.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfiguration {
  @Value("${spring.redis.host}")
  private String host;

  @Value("${spring.redis.port}")
  private String password;

  @Value("${spring.redis.port}")
  private int port;

  @Value("${spring.redis.timeout}")
  private int timeout;

  @Bean
  public JedisPool jedisPool() {
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    jedisPoolConfig.setMaxIdle(10);
    jedisPoolConfig.setMaxTotal(20);
    jedisPoolConfig.setMinIdle(2);
    jedisPoolConfig.setBlockWhenExhausted(true);

    return new JedisPool(jedisPoolConfig, host, port, timeout, password);
  }
}
