package wang.seamas.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import wang.seamas.model.Customer;
import wang.seamas.model.User;
import wang.seamas.service.CustomerService;
import wang.seamas.service.UserService;

@RestController
@Slf4j
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    CustomerService customerService;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("user")
    public Object user() {

        User hello = userService.findByName("hello");
        hello = userService.findByName("hello");
        return hello;
    }

    @GetMapping("customer")
    public Object customer() {
        Customer hello = customerService.findByName("seamas");
        hello = customerService.findByName("seamas");
        return hello;
    }

    @PostMapping("publish")
    public void publish(@RequestBody String message) {
        redisTemplate.convertAndSend("MV", message);
    }
}
