package wang.seamas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.seamas.service.TranService;

@RestController
@RequestMapping("tran")
public class TranController {

    @Autowired
    TranService tranService;

    @RequestMapping("add")
    public Object add() {
        return tranService.executeWithoutTransaction();
    }

    @RequestMapping("all")
    public Object all() {
        return tranService.executeWithTransaction();
    }
}
