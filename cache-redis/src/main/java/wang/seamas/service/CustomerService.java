package wang.seamas.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import wang.seamas.model.Customer;

import java.util.HashMap;
import java.util.Map;

@Service
@CacheConfig(cacheNames = "customer")
@Slf4j
public class CustomerService {

    private static final Map<String, Customer> map;

    static {
        map = new HashMap<>();
        map.put("seamas", new Customer("seamas", "hz", "seamas@abc.com"));
        map.put("wang", new Customer("wang", "qz", "wang@abc.com"));
    }

    @Cacheable
    public Customer findByName(String name) {
        return map.getOrDefault(name, null);
    }
}
