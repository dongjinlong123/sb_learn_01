package com.djl.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration // 自动装配bean到spring 容器
public class RedisCacheManage {
    /**
     * 注入spring中的缓存管理类
     * @param stringRedisTemplate
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager(@Qualifier("stringRedisTemplate") StringRedisTemplate stringRedisTemplate) {
        RedisCacheManager cm = new RedisCacheManager(stringRedisTemplate);
        Map<String,Long> map = new HashMap<String,Long>();
        map.put("amout", 100l);
        map.put("amout_backup",100l);
        cm.setExpires(map);
        return cm;
    }
}
