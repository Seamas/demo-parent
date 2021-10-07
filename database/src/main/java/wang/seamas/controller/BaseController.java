package wang.seamas.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import wang.seamas.model.User;
import wang.seamas.service.UserService;

public class BaseController {

    protected UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("create")
    public int createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("delete")
    public int deleteUser(@RequestBody User user) {
        return userService.deleteByName(user.getName());
    }

    @PostMapping("deleteAll")
    public int deleteAll() {
        return userService.deleteAllUsers();
    }
}
