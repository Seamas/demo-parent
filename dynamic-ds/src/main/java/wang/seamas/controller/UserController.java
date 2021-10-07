package wang.seamas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.seamas.model.User;
import wang.seamas.service.UserService;

@RestController
public class UserController {

    @Autowired
    @Qualifier("masterUserServiceImpl")
    UserService master;

    @Autowired
    @Qualifier("slaveUserServiceImpl")
    UserService slave;

    @RequestMapping("master")
    public Object master(@RequestBody User user) {
        return master.addUser(user);
    }

    @RequestMapping("slave")
    public Object slave(@RequestBody User user) {
        return slave.addUser(user);
    }

    @GetMapping("all")
    public Object all() {
        return master.selectAll();
    }
}
