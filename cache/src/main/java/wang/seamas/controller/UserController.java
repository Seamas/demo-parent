package wang.seamas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.seamas.model.User;
import wang.seamas.service.CacheService;

@RestController
public class UserController {

    @Autowired
    CacheService cacheService;

    @Autowired
    CacheManager cacheManager;

    @GetMapping("user")
    public Object user() {
        User hello = cacheService.findByName("hello");
        hello = cacheService.findByName("hello");
        return hello;
    }
}
