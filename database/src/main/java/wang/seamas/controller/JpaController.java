package wang.seamas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.seamas.service.UserService;

@RestController
@RequestMapping("jpa")
public class JpaController extends BaseController {

    @Override
    @Autowired
    public void setUserService(@Qualifier("jpaUserServiceImpl") UserService userService) {
        super.setUserService(userService);
    }
}
