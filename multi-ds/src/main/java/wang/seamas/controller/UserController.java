package wang.seamas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wang.seamas.model.User;
import wang.seamas.service.PrimaryUserService;
import wang.seamas.service.SecondaryUserService;

@RestController
public class UserController {

    @Autowired
    PrimaryUserService master;

    @Autowired
    @Qualifier("slaveUserService")
    SecondaryUserService slave;

    @PostMapping("master")
    public Object master(@RequestBody User user) {
        return master.addUser(user);
    }


    @PostMapping("slave")
    public Object slave(@RequestBody User user) {
        return slave.addUser(user);
    }
}
