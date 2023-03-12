package org.skillhub.config;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
//@RequiredArgsConstructor
public class RedisConfig {

//  @Value("spring.data.redis.host")
  final String host = "127.0.0.1";

//  @Value("spring.data.redis.port")
  final Integer port = 6379;

//  @Bean
//  public JedisConnectionFactory connectionFactory() {
//    RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//    redisStandaloneConfiguration.setHostName(host);
//    redisStandaloneConfiguration.setPort(port);
//    return new JedisConnectionFactory(redisStandaloneConfiguration);
//  }

//  @Bean
//  public LettuceConnectionFactory connectionFactory(){
//    LettuceConfiguration
//  }


  @Bean
  public RedisTemplate<String, Object> redisTemplate() {
    RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
    redisStandaloneConfiguration.setPassword(RedisPassword.none());
    redisStandaloneConfiguration.setPort(port);
    redisStandaloneConfiguration.setHostName(host);
    JedisConnectionFactory connectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
    connectionFactory.afterPropertiesSet();

    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(connectionFactory);
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
    redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
    redisTemplate.setEnableTransactionSupport(true);
    return redisTemplate;
  }
}
