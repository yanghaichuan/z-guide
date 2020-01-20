package com.yhc.example.zguide.user.sev.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: redis配置
 * @Auther: gavin
 * @Date: 2019/04/26 11:46
 */
@EnableCaching
@Configuration
public class RedisCacheConfig {
//    /**
//     * 密码缓存 key
//     */
//    public final static String oauthEncryptedCache = "oauth_encrypted_cache";
//    /**
//     * 加载用户信息缓存 key
//     */
//    public final static String oauthCacheLoadByUsername = "loadbyusername_cache";
//    /**
//     * 加载客户端权限缓存 key
//     */
//    public final static String ssoClientCache = "sso_client_cache";

    /**
     * 缓存区域 key
     */
    public final static String areaCache = "area_cache";

    @Bean
    public CacheManager cacheManager(LettuceConnectionFactory lettuceConnectionFactory) {
        return new RedisCacheManager(
                RedisCacheWriter.nonLockingRedisCacheWriter(lettuceConnectionFactory),
                this.getRedisCacheConfigurationWithTtl(-1, new JdkSerializationRedisSerializer()), // 默认策略，未配置的 key 会使用这个
                this.getRedisCacheConfigurationMap() // 指定 key 策略
        );
    }

    /**
     * 如有缓存过期时间要求，请自定义 每个缓存过期时间 对应设置@Cacheable的value值
     * @return
     */
    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
//        //用户密码解密缓存5分钟
//        redisCacheConfigurationMap.put(oauthEncryptedCache, this.getRedisCacheConfigurationWithTtl(300, null));
//        //加载用户信息缓存5分钟
//        redisCacheConfigurationMap.put(oauthCacheLoadByUsername, this.getRedisCacheConfigurationWithTtl(300, null));
//        //加载客户端缓存5分钟  如果是缓存ResultMap，用JdkSerializationRedisSerializer，Jackson2Json多层结构序列化不出来
//        redisCacheConfigurationMap.put(ssoClientCache, this.getRedisCacheConfigurationWithTtl(7200, new JdkSerializationRedisSerializer()));
//        //区域缓存1分钟
        redisCacheConfigurationMap.put(areaCache, this.getRedisCacheConfigurationWithTtl(60, null));
        return redisCacheConfigurationMap;
    }

    /**
     * 指定过期时间和序列化实现类
     * @param seconds
     * @param redisSerializer
     * @return
     */
    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds, RedisSerializer redisSerializer) {
        // 设置序列化
        if(redisSerializer == null) {
            redisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            ((Jackson2JsonRedisSerializer<Object>) redisSerializer).setObjectMapper(om);
        }

        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
                RedisSerializationContext
                        .SerializationPair
                        .fromSerializer(redisSerializer)
        ).entryTtl(Duration.ofSeconds(seconds));

        return redisCacheConfiguration;
    }

    /**
     * RedisTemplate配置
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        // 设置序列化
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        // 配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);
        RedisSerializer<?> stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);// key序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);// value序列化
        redisTemplate.setHashKeySerializer(stringSerializer);// Hash key序列化
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);// Hash value序列化
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
