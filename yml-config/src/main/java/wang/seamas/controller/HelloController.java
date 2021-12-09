package wang.seamas.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.seamas.config.Config;
import wang.seamas.config.Cust;

@RestController
@AllArgsConstructor
public class HelloController {

    Config config;
    Cust cust;

    @GetMapping("custom")
    public Cust getCust() {
        return cust;
    }

    @GetMapping("config")
    public Config getConfig() {
        return config;
    }
}
