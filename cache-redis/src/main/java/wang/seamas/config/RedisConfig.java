package wang.seamas.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import wang.seamas.model.Customer;
import wang.seamas.model.User;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class RedisConfig {

    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        return new RedisCacheManager(
                RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),
                getRedisCacheConfigurationWithTtl(60),  // 如果没有配置，采用默认策略
                getRedisCacheConfigurationMap()
        );
    }

    private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
        Map<String, RedisCacheConfiguration> map = new HashMap<>();
        map.put("user", createRedisCacheConfigWithTtl(User.class, 30));
        map.put("customer", createRedisCacheConfigWithTtl(Customer.class, 30));
        return map;
    }

    private <T> RedisCacheConfiguration createRedisCacheConfigWithTtl(Class<T> clazz, Integer ttl) {
        // 使用json序列化及反序列化，需要设置 每个cache的 serializer
        Jackson2JsonRedisSerializer<T> serializer = new Jackson2JsonRedisSerializer<>(clazz);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        serializer.setObjectMapper(objectMapper);

        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
        RedisCacheConfiguration finalConfiguration = defaultCacheConfig
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer))
                .entryTtl(Duration.ofSeconds(ttl));
        return finalConfiguration;
    }

    private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer ttl) {
        return createRedisCacheConfigWithTtl(Object.class, ttl);
    }
}
