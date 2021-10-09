package wang.seamas.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
