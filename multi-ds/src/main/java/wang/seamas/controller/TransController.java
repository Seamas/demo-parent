package wang.seamas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.seamas.service.PrimaryUserService;
import wang.seamas.service.SecondaryUserService;

@RestController
@RequestMapping("trans")
public class TransController {

    @Autowired
    PrimaryUserService master;

    @Autowired
    @Qualifier("slaveUserService")
    SecondaryUserService slave;

    @GetMapping("master")
    public Object master() {
        return master.addAll();
    }


    @GetMapping("slave")
    public Object slave() {
        return slave.addAll();
    }
}
