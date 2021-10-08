package wang.seamas.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import wang.seamas.model.User;

import java.util.HashMap;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "customer")
@Slf4j
public class CacheService {

    private static final Map<String, User> map;

    static {
        map = new HashMap<>();
        map.put("hello", new User("hello", 10));
        map.put("world", new User("world", 20));
    }

    @Cacheable
    public User findByName(String name) {
        log.info("start search user name: {}", name);
        User user = map.getOrDefault(name, null);
        log.info("finish search name: {}", name);
        return user;
    }
}
