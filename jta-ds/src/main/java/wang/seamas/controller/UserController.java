package wang.seamas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.seamas.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("master")
    public Object master() {
        return userService.addAll();
    }
}
