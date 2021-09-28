package wang.seamas.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.seamas.config.SeamasProperties;
import wang.seamas.model.vo.request.User;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    SeamasProperties properties;


    @GetMapping("prop")
    public Object prop() {
        Object obj = properties;
        log.info("obj : {}", obj);
        return obj;
    }

    @GetMapping("user")
    public Object user(@Valid User user) {



        return "hello";
    }
}
